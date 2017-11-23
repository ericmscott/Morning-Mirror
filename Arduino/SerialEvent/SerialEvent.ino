//last updated: November 20, 2017

String inputString = "";         // a string to hold incoming data
boolean stringComplete = false;  // whether the string is complete

boolean buzzerOn = false;

//PIN CONNECTIONS

//Analog Pins
const int temperaturePin = 5; //temp. sensor to arduino pin 5
const int irPin0 = 0;          //IR receiver to arduino pin 0
const int irPin1 = 1;          //IR receiver to arduino pin 1
const int irPin2 = 2;          //IR receiver to arduino pin 2
const int irPin3 = 3;          //IR receiver to arduino pin 3
//Digital Pins
const int buzzerPin = 3; //buzzer to arduino pin 3
const int buttonPin = 7; //button to arduino pin 7
const int irLedPin = 12; //ir LED to arduino pin 12

boolean IRButton1;
boolean IRButton2;
boolean IRButton3;
boolean IRButton4;

boolean flag1;
boolean flag2;
boolean flag3;
boolean flag4;


void setup() {
  //debugging LEDs
  //blue led
  //pinMode(7, OUTPUT);
  //green led
  //pinMode(2, OUTPUT);
  
  // Set buzzer - pin 3 as an output
  pinMode(buzzerPin, OUTPUT);
  // Set button - pin 7 as an input
  pinMode(buttonPin, INPUT);
  //set IR LED - pin 12 as output
  pinMode(irLedPin,OUTPUT);
   

  // initialize serial:
  Serial.begin(9600);
  
  // reserve 200 bytes for the inputString:
  inputString.reserve(200);

  //start with IR led on
  digitalWrite(irLedPin, 1);

  randomSeed(analogRead(0));

}

void loop() {

  //when arduino has received a request from server, send appropriate information back
  if (stringComplete) 
  {
    if(buzzerOn == true){
      noTone(buzzerPin);
    }

    int complete = 0;
    
    if(inputString=="1")
    {
      float temp = random(300);
      //temp = getTemperature();
      char str[20];
      sprintf(str, "%d", (int)temp);
      //Serial.println(str);
      
      Serial.write(str); //actual
      /*float temp = random(300);
      //temp = getTemperature();
      char str[20];
      sprintf(str, "%d.%02d", (int)temp, (int)(temp*100)%100);
      Serial.println(str);
      */
      //Serial.write(str); //actual
      
      //for testing
      //Serial.write("2 received");
      complete = 1;

    }
    else if(inputString=="3")
    {
      /*boolean state = toggleBuzzer();
      if(state == true)
        Serial.write("Buzzer:true",11);
      else
        Serial.write("Buzzer:false",12);
*/
      Serial.write("3 received");
      complete = 1;

    }
    else if(inputString=="4")
    {
      boolean state = getPushButtonState();
      if(state == true)
        Serial.write("Button:true",11);
      else
        Serial.write("Button:false",12);

      complete = 1;
      
    }
    else if(inputString=="5")
    {
      //this does not implement the quadrants, just looking at the ir sensors individually
      if(flag1 == true){
        Serial.write("irButton 1 on");
        flag1 = false;
      }
      if(flag2 == true){
        Serial.write("irButton 2 on");
        flag2 = false;
      }
      if(flag3 == true){
        Serial.write("irButton 3 on");
        flag3 = false;
      }
      if(flag4 == true){
        Serial.write("irButton 4 on");
        flag4 = false;
      }
      complete = 1;
    }

    //0000 will be used for errors
    if(complete == 0){  
      Serial.write(0000);
    }
      
    // clear the string:
    inputString = "";
    stringComplete = false;

    //set complete back to 0
    complete = 0;
  }
  /*
  //check if IR sensors have noticed something
  IRButton1 = getIRButtonState(0);
  IRButton2 = getIRButtonState(1);
  IRButton3 = getIRButtonState(2);
  IRButton4 = getIRButtonState(3);
  if(IRButton1 == true)
    flag1 = true;
  if(IRButton2 == true)
    flag2 = true;
  if(IRButton3 == true)
    flag3 = true;
  if(IRButton4 == true)
    flag4 = true;
    */
}

/*
  SerialEvent occurs whenever a new data comes in the
 hardware serial RX.  This routine is run between each
 time loop() runs, so using delay inside loop can delay
 response.  Multiple bytes of data may be available.
 */
void serialEvent() {
  while (Serial.available()) {
    // get the new byte:
    char inChar = (char)Serial.read();
    // add it to the inputString:
    inputString += inChar;
    // if the incoming character is what were expecting, set a flag
    // so the main loop can do something about it:
    if (inChar == '\n' || inChar == '2' || inChar == '3' || inChar == '4' || inChar == '5' || inChar == '1') {
      stringComplete = true;
    }
  }

}

/*
 * Description: This method reads from the temperature sensor, converts it to degrees celsius, and then returns the
 *              temperature.
 * input: none
 * output: float representing temperature in degrees celsius
 */
float getTemperature() {
  //read value from temperature sensor
  int reading = analogRead(temperaturePin);  
  float temperatureC = 0.48828125 * reading ;  //converting from 10 mv per degree wit 500 mV offset
                                               //to degrees ((voltage - 500mV) times 100)

  //print to serial monitor for debugging purposes
  //Serial.print(temperatureC); Serial.println(" degrees C");
  
  return temperatureC;
  
  /*//Faranheit conversion
  float temperatureF = (temperatureC * 9.0 / 5.0) + 32.0;
  Serial.print(temperatureF); Serial.println(" degrees F");*/
}

boolean toggleBuzzer(){
  buzzerOn = true;
  int i = 0;
  if( i < 5){
    tone(buzzerPin, 5000); // Send 5KHz sound signal...
    delay(500);        // ...for 1 sec
    noTone(buzzerPin);     // Stop sound...
    delay(500);        // ...for 1sec
    i++;
  }
  return buzzerOn;
}

boolean getPushButtonState(){
  //status of push button
  int buttonState = digitalRead(buttonPin);
  if(buttonState == 1)
    return true;
  else
    return false;
}

boolean getIRButtonState(int x)
{
  const int threshold = 400;
  int reading = 5000;
  
  if(x == 0)
  {
     reading = analogRead(irPin0);
  }
  else if(x == 1)
  {
    reading = analogRead(irPin1);
  }
  else if (x == 2)
  {
    reading = analogRead(irPin2);
  }
  else if(x == 3)
  {
    reading = analogRead(irPin3);
  }
  else
    return false;

  if(reading == 5000 || reading < 0 || reading > 1023 )
    return false;

  return reading > threshold;
}




