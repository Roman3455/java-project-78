### Hexlet tests and linter status:

[![Actions Status](https://github.com/Roman3455/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Roman3455/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/a74e5f29eeca13abd168/maintainability)](https://codeclimate.com/github/Roman3455/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/a74e5f29eeca13abd168/test_coverage)](https://codeclimate.com/github/Roman3455/java-project-78/test_coverage)
[![Project-78-CI](https://github.com/Roman3455/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/Roman3455/java-project-78/actions/workflows/main.yml)

# Data Validator

Data validator is a library that can be used to check the correctness of any data.  The project is based on the yup library.

## Usage example

````java
Validator v = new Validator();

// Строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// Числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Объект Map с поддержкой проверки структуры
Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("firstName", "Anna");
human2.put("lastName", "B");
schema.isValid(human2); // false
````

### Run app

```sh
make build-run
```
