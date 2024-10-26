.DEFAULT_GOAL := build-run

clean:
	make -C app clean
build:
	make -C app build
installDist:
	make -C app installDist
run-dist:
	make -C run-dist
test:
	make -C app test
report:
	make -C app report
lint:
	make -C app lint

build-run: clean build installDist lint test report run-dist

.PHONY: build
