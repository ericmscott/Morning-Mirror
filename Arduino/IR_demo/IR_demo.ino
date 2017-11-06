int irPin = 0;
int ledPin = 13;
int reading = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);

}

void loop() {
  // put your main code here, to run repeatedly:

  //turn on IR led
  digitalWrite(ledPin, 1);
  //read from analog input
  reading = analogRead(irPin);
  //print to serial monitor
  Serial.print(reading);
  Serial.print("\n");
  //add delay 100 ms
  delay(100);

}
