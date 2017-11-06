
const int buttonPin = 7;     // the number of the pushbutton pin
const int ledPin =  13;      // the number of the LED pin

int buttonState = 0;         // status of pushbutton

void setup() {
  // initialize the LED pin as an output, pushbutton as input:
  pinMode(ledPin, OUTPUT);
  pinMode(buttonPin, INPUT);
}

void loop() {
  // read the state of the pushbutton value:
  buttonState = digitalRead(buttonPin);
  if (buttonState == 1) {
    // turn LED on:
    digitalWrite(ledPin, 1);
  } else {
    // turn LED off:
    digitalWrite(ledPin, 0);
  }
}
