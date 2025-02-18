# LimitApi

LimitApi is a Java-based API rate limiting library designed to protect API endpoints from excessive load and potential failures.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Project Overview
LimitApi implements robust rate limiting to safeguard APIs by using a fixed window algorithm, ensuring endpoints are not overwhelmed by too many requests.

## Features
- **Rate Limiting**: Fixed window algorithm limiting requests to 15 per timeframe.
- **Scalability**: Database sharding across multiple servers to handle increased traffic.
- **High Availability**: Designed for 99.9% uptime through distributed system architecture.

## Installation
To set up LimitApi locally:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/namekart-piyush/limitapi.git
   cd limitapi
   ```

2. **Install dependencies**:
   ```bash
   mvn install
   ```

3. **Configure environment**:
   Create an `application.properties` file in `src/main/resources`:
   ```plaintext
   server.port=8081
   spring.datasource.url=jdbc:mysql://localhost:3306/limitapidb
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.data.redis.host=localhost
   spring.data.redis.port=6379
   ```

4. **Start the application**:
   ```bash
   mvn spring-boot:run
   ```

## Usage
- **API Developers**: Integrate LimitApi to protect your APIs from overuse and ensure service availability.

## Technologies Used
- **Backend**: Java, Spring Boot
- **Database**: MySQL, Redis for caching and rate limiting

## Contributing
Contributions are welcome:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-yourfeature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature-yourfeature`).
5. Submit a Pull Request.

## Contact
- **Author**: Piyush Singh
- **GitHub**: [Piyush Singh](https://github.com/namekart-piyush)
- **LinkedIn**: [Piyush Singh](https://www.linkedin.com/in/piyush-singh908)
