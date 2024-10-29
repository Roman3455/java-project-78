.DEFAULT_GOAL := build-run

clean:
	./gradlew clean
build:
	./gradlew build
test:
	./gradlew test
report:
	./gradlew jacocoTestReport
lint:
	./gradlew checkstyleMain checkstyleTest

build-run: clean build lint test report

.PHONY: build