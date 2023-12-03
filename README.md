# Cricket Game Simulator

A Java-based cricket game simulator developed with Spring Boot. This project includes classes for players (Batsman and Bowler), a match controller API, a scoreboard, and functionalities for simulating cricket matches with detailed statistics. Users can start individual matches or series, with match details and player statistics stored in a database.

## Technologies Used

- Spring Boot: Java framework for rapid application development
- Elasticsearch: Distributed search and analytics engine for storing and retrieving cricket match data
- Kafka: Distributed streaming platform for real-time event processing, such as live match updates
- MongoDB: NoSQL database for storing player information and match statistics

## Features

- **Game Simulation:** Simulates cricket matches with random events for each ball, including runs, wickets, wides, and no-balls.

- **Player Roles:** Distinguishes players as Batsmen or Bowlers, providing unique attributes for each role.

- **Statistics:** Stores match results, scoreboard details, and individual player statistics in a database.

- **Real-time Data Processing:** Utilizes Kafka to stream live match updates and provide real-time insights.

- **Elasticsearch Search:** Enables efficient search and retrieval of cricket match data using Elasticsearch's powerful search capabilities.

- **API Endpoints:** Includes APIs to start a match, start a series, fetch match details, and retrieve data from the database.

- **Branching Strategy:** Implements a daily branching strategy for version control, ensuring a detailed history of changes.

Feel free to explore, contribute, and enhance this cricket game simulator!
