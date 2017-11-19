String inputString = "";         // a string to hold incoming data
boolean stringComplete = false;  // whether the string is complete

boolean buzzerOn = false;

//PIN CONNECTIONS
//connected to analog pin 0
const int temperaturePin = 0;
const int buzzerPin = 3; //buzzer to arduino pin 3
const int buttonPin = 7; //button to arduino pin 7

void setup() {
  //blue led
  pinMode(7, OUTPUT);
  //green led
  pinMode(2, OUTPUT);
  
  // Set buzzer - pin 3 as an output
  pinMode(buzzerPin, OUTPUT);
  // Set button - pin 7 as an input
  pinMode(buttonPin, INPUT); 

  // initialize serial:
  Serial.begin(9600);
  
  // reserve 200 bytes for the inputString:
  inputString.reserve(200);

  
}

void loop() {
  
  // print the string when a newline arrives:
  if (stringComplete) {
    if(buzzerOn == true){
      noTone(buzzerPin);
    }
    //LED test
    digitalWrite(7, 1);
    int complete = 0;
    if(inputString=="2")
    {
      float temp = getTemperature();
      Serial.write(temp);
      complete = 1;
    }
    else if(inputString=="3")
    {
      boolean state = toggleBuzzer();
      if(state == true)
        Serial.write("Buzzer:true",11);
      else
        Serial.write("Buzzer:false",12);
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
      //getIRButtonState()
      temp = 20;
    }

    //0000 will be used for errors
    if(complete == 0){  
      Serial.write(0000);
      digitalWrite(2, 1);
    }
      
    // clear the string:
    inputString = "";
    stringComplete = false;

    //set complete back to 0
    complete = 0;
    //turn BLUE led off
    digitalWrite(7, 0);
  }
}

/*
  SerialEvent occurs whenever a new data comes in the
 hardware serial RX.  This routine is run between each
 time loop() runs, so using delay inside loop can delay
 response.  Multiple bytes of data may be available.
 */
void serialEvent() {
  while (Serial.available()) {
    //digitalWrite(7, 1);
    // get the new byte:
    char inChar = (char)Serial.read();
    // add it to the inputString:
    inputString += inChar;
    // if the incoming character is a newline, set a flag
    // so the main loop can do something about it:
    if (inChar == '\n' || inChar == '2' || inChar == '3' || inChar == '4' || inChar == '5') {
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




