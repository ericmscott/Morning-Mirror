int irPin = 1;
int ledPin = 8;
int irPowerPin = 9;
int reading = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);
  //turn on IR led
  digitalWrite(ledPin, 1);

    pinMode(irPowerPin, OUTPUT);
  //turn on IR led
  digitalWrite(irPowerPin, 1);
}

void loop() {
  // put your main code here, to run repeatedly:


  //read from analog input
  reading = analogRead(irPin);
  //print to serial monitor
  Serial.print(reading);
  Serial.print("\n");
  //add delay 100 ms
  delay(100);

}
