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
      /*float temp = random(300);
      //temp = getTemperature();
      char str[20];
      sprintf(str, "%d", (int)temp);
      //Serial.println(str);*/
      //float temp = random(300);
      
      //get each one, and append to string, write to serial comm.
      String msgToServer = "";

      //append IR button states
      msgToServer += updateIRButtons();

      //append push button state
      msgToServer += getPushButtonState();

      //append temperature
      msgToServer += getTemperature();
      
      //Serial.print(msgToServer); 
      Serial.print("1001123.223333");

      //flag that indicates that message has been sent to server
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
   
}
//this implementation looks at IR sensors individually
//get latest version of IR buttons
String updateIRButtons(){
  
  //state of IR buttons will be appended to this string (1 for ON, 0 for OFF)
  String temp = "";

  //check IR button 1
  if(flag1 == true){
    temp+="1";
    //update flag to receive new button requests
    flag1 = false;
  }else
    temp+="0";
    
  //check IR button 2
  if(flag2 == true){
    temp+="1";
    flag2 = false;
  }else
    temp+="0";

  //check IR button 3
  if(flag3 == true){
    temp+="1";
    flag3 = false;
  }else
    temp+="0";

  //check IR button 4
  if(flag4 == true){
    temp+="1";
    flag4 = false;
  }else
    temp+="0";

  return temp;
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
String getTemperature() {
  //read value from temperature sensor
  int reading = analogRead(temperaturePin);  
  float temperatureC = 0.4883 * reading ;  //converting from 10 mv per degree wit 500 mV offset
                                               //to degrees ((voltage - 500mV) times 100)

  
  char str[20];
  sprintf(str, "%d.%02d", (int)temperatureC, (int)(temperatureC*100)%100);
  //Serial.println(str);
  return str;
  
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

String getPushButtonState(){
  //status of push button
  int buttonState = digitalRead(buttonPin);
  
  if(buttonState == 1)
    return "1";
  else
    return "0";
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




