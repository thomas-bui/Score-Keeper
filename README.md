# ScoreKeeper

ScoreKeep computes the total score for the game of Ten Pin bowling.

ScoreKeeper is able to provide the running score even when the ten frames are incomplete.

## Requirements

* Java 7
* JUnit 4
* Maven (Optional)

## Usage

The score for each turn is provided as a space separated string

```java
    public int computeScore(String inputLine) throws InvalidInputException
```

ScoreKeeper computes the total score using the rules of Ten Pin bowling and returns the value as integer.

ScoreKeeper will also validate the input and throw a corresponding Exception if the input is illegal.

| Exception | Description |
| ----------|-------------|
| InvalidInputException | The parent Exception. Indicates a general error such illegal turn score has been provided |
| MaximumFramesException | Thrown when the input exceeds the maximum number of frames in Ten Pin|
| MaximumPinsException | Thrown when the input contains a frame which exceeds the maximum number of pins. This handles special scenarios for the last frame|

## Unit Tests

Running Unit tests requires JUnit 4. This can be retrieved using Maven

```
mvn dependency:resolve
```

