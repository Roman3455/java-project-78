.DEFAULT_GOAL := build-run

clean:
	./gradlew clean
build:
	./gradlew build
installDist:
	./gradlew installDist
run-dist:
	./build/install/app/bin/app
test:
	./gradlew test
report:
	./gradlew jacocoTestReport
lint:
	./gradlew checkstyleMain checkstyleTest

build-run: clean build installDist lint test report run-dist

.PHONY: build