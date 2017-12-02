//last updated: November 27, 2017

String inputString = "";         // a string to hold incoming data
boolean stringComplete = false;  // whether the string is complete

//PIN CONNECTIONS

//Analog Pin Connections
const int temperaturePin = 5; //temp. sensor to arduino pin 5
const int irPin0 = 0;          //IR receiver to arduino pin 0
const int irPin1 = 1;          //IR receiver to arduino pin 1

//Digital Pins Connections
const int buzzerPin = 3; //buzzer to arduino pin 3
const int buttonPin = 7; //button to arduino pin 7

const int irLedPin1 = 8; //ir LED to arduino pin 12
const int irLedPin2 = 10; //ir LED to arduino pin 11
const int ir1PowerPin = 9;
const int ir2PowerPin = 11;

//state of IR Buttons
boolean IRButton1=false;
boolean IRButton2=false;

//flags for IR Buttons to determine if it has been pressed
boolean irFlag1=false;
boolean irFlag2=false;

boolean buttonFlag = false;

//threshold to determine if IR receiver has sensed something
const int irThreshold = 800;

//boolean to determine if in power saving mode or regular mode
boolean sleepMode = false;

//state of Buzzer
boolean buzzerState = false;
/*
 * This method is run initially to setup sensors 
 * and baud rate for serial communication.
 */
void setup() {
  //debugging LEDs
  //blue led
  pinMode(13, OUTPUT);

  
  // Set buzzer - pin 3 as an output
  pinMode(buzzerPin, OUTPUT);
  // Set button - pin 7 as an input
  pinMode(buttonPin, INPUT);
  
  //set IR LEDs to output: pin 9-12
  pinMode(irLedPin1,OUTPUT);
  pinMode(irLedPin2,OUTPUT);
  pinMode(ir1PowerPin,OUTPUT);
  pinMode(ir2PowerPin,OUTPUT);

  // initialize serial baud rate:
  Serial.begin(9600);
  
  // reserve 200 bytes for the inputString:
  inputString.reserve(200);
  
  //start with all IR leds ON
  digitalWrite(irLedPin1, 1);
  digitalWrite(irLedPin2, 1);
  digitalWrite(ir1PowerPin, 1);
  digitalWrite(ir2PowerPin, 1);
  
}

/*
 * This is the main method that will be constantly looping
 */
void loop() {

  //when arduino has received a request from server, send appropriate information back
  if (stringComplete) 
  {
    int complete = 0;
    
    if(inputString=="1")
    {
      //get each one, and append to string, write to serial comm.
      String msgToServer = "";

      //append IR button states
      msgToServer += updateIRButtons();
      msgToServer += "00";

      //append push button state
      if(buttonFlag == true){
        msgToServer += "1";
        buttonFlag = false;
      }
      else
        msgToServer += "0";
      
      //append temperature
      msgToServer += getTemperature();
      
      //Serial.print(msgToServer); 
      Serial.print(msgToServer);

      //flag that indicates that message has been sent to server
      complete = 1;
      msgToServer = "";

    }
    else if(inputString == "2")
    {
      
      //toggle the Buzzer if the command from server is "2"
      if(buzzerState == true)
        buzzerState = false;
      else
        buzzerState = true;

      
      //send message back to server to acknowledge request to toggle buzzer
      Serial.print("ack");
      //flag that indicates message has been sent to server
      complete = 1;

    }
    else if(inputString=="3")
    {
      //toggle sleep for arduino if the command from server is "3"
      if(sleepMode == true)
        sleepMode = false;
      else
        sleepMode = true;

      //send message back to server to acknowledge request to toggle buzzer
      Serial.print("ack");
      
      //flag that indicates that message has been sent to server
      complete = 1;
    }
    else if(inputString =="4")
    {
      //test connection with server for request = "4", send message through serial communication
      Serial.print("test received");
      //flag that indicates that message has been sent to server
      complete = 1;
    }

    //if appropriate command was not sent, relay that to server
    if(complete == 0){  
      Serial.print("Not appropriate command");
    }
      
    //clear the string sent by server
    inputString = "";
    //set flag back to false
    stringComplete = false;
    //clear msg to server
    //set complete back to 0
    complete = 0;
  }
  
  if(buzzerState == true)
      toggleBuzzer();
  
  //check if button is being pressed
  if(getPushButtonState() == 1)
    buttonFlag = true;
    
  //if the Arduino is in sleep mode don't spend time
  //checking if the IR buttons have been pressed
  //if(sleepMode == false){
    //check if IR sensors have noticed something
    IRButton1 = getIRButtonState(0);
    IRButton2 = getIRButtonState(1);

    //set a flag if the IR sensors have noticed something
    if(IRButton1 == true)
      irFlag1 = true;
    if(IRButton2 == true)
      irFlag2 = true;

  //}
   
}
//this implementation looks at IR sensors individually
//get latest version of IR buttons
String updateIRButtons(){
  
  //state of IR buttons will be appended to this string (1 for ON, 0 for OFF)
  String temp = "";

  //check IR button 1
  if(irFlag1 == true){
    temp+="1";
    //update flag to receive new button requests
    irFlag1 = false;
  }else
    temp+="0";
    
  //check IR button 2
  if(irFlag2 == true){
    temp+="1";
    irFlag2 = false;
  }else
    temp+="0";


  return temp;
}

/*
 * SerialEvent occurs whenever a new data comes in the
 * hardware serial RX.  This routine is run between each
 * time loop() runs.
 */
void serialEvent() {
  //check if serial line is available
  while (Serial.available()) {
    // get the new byte:
    char incomingChar = (char)Serial.read();
    // add it to the inputString:
    inputString += incomingChar;
    
    // if the incoming character is what were expecting, set a flag "stringComplete"
    // so the main loop can do something about it:
    if (incomingChar == '1' || incomingChar == '2' || incomingChar == '3' || incomingChar == '4')
      stringComplete = true;
  }
}

/*
 * Description: This method reads from the temperature sensor, converts it to degrees celsius, and then returns the
 *              temperature.
 * input: none
 * output: String representing temperature in degrees celsius
 */
String getTemperature() {
  //read value from temperature sensor
  //convert reading to a temperature in degrees Celsius  
  float temperatureC = 0.48828125 * analogRead(temperaturePin) ;  

  //convert temperature as a string formatted xx.xx, and return
  char str[10];
  sprintf(str, "%d.%02d", (int)temperatureC, (int)(temperatureC*100)%100);

  return str;
}

/*
 * If the server sends a message to toggle the buzzer then this method is called.
 * It toggles the buzzer between on and off to simulate an alarm clock.
 */
void toggleBuzzer(){
  int cycle = 0;
  if( cycle < 5){
    tone(buzzerPin, 4500); // Send 5KHz sound signal...
    delay(500);        // ...for 1 sec
    noTone(buzzerPin);     // Stop sound...
    delay(500);        // ...for 1sec
    cycle++;
  }
  
}

/*
 * Return the state of the push button
 */
int getPushButtonState(){
  return digitalRead(buttonPin);
}

/*
 * Returns the state of a IR Button depending 
 * on which pin it is checking.
 */
boolean getIRButtonState(int pin)
{
  //set baseline reading
  int reading = -1;

  //determine which pin was sent as argument, and read from that 
  //specific IR sensor
  if(pin == 0)
     reading = analogRead(irPin0);
  else if(pin == 1)
    reading = analogRead(irPin1); 
  else
    return false;
    
  //if reading hasn't changed, or is out of bounds, return false 
  if(reading == -1 || reading < 0 || reading > 1023 )
    return false;
    
  //if the IR reading is below threshold, then IR has detected something and return true
  //if it's less, return valse;
  return reading < irThreshold;
}




