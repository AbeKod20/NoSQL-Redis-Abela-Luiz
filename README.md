# NoSQL-Datenbank-Redis

> A simple Java project demonstrating how to connect to a Redis database (hosted on Upstash), write data, and perform search operations.

---

## Table of Contents

1. [Overview](#overview)
2. [Technologies Used](#technologies-used)
3. [Installation & Setup](#installation--setup)
4. [How to Run](#how-to-run)
5. [Features](#features)
6. [Team](#team)
7. [Documentation & Work Log](#documentation--work-log)
8. [License](#license)

---

## Overview

This repository contains a Java application that:
- Connects to a **Redis NoSQL database** on [Upstash](https://upstash.com).
- Stores mock data (10,000 records) with UUID keys.
- Performs simple searches:
  1. **Search by Key** (direct Redis `GET`).
  2. **Search by `firstName`** (simple iteration or advanced indexing if needed).
- Measures execution time for these search operations.

---

## Technologies Used

- **Java** (version 17 or above recommended)
- **Redis** (hosted via Upstash)
- **Jedis** (or another Redis Java client library)
- **Mockaroo** (for generating sample data)
- **DataGrip** (optional, for database visualization/inspection)

---

## Installation & Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   cd your-repo-name

# Project Work Logbook

This logbook documents who did what and when, including a more detailed description of the activities.

| Date        | Time From - To     | Duration (Minutes) | Name          | Description of Work                                                         |
|-------------|--------------------|---------------------|---------------|------------------------------------------------------------------------------|
| 2025-04-15  | 14:00 - 16:30      | 150                 | Abela Kodra   | Tested connection with Redis, adjusted Jedis configuration, prepared CSV file |
| 2025-04-15  | 16:30 - 17:00      | 30                  | Luiz Marku    | Generated mock data (makaroo), validated .csv files                          |
| 2025-04-16  | 09:00 - 10:30      | 90                  | Abela Kodra   | Implemented search methods by key and first name, added time measurement     |
| 2025-04-16  | 10:30 - 11:30      | 60                  | Luiz Marku    | Code review and refactoring of RedisService class                            |
| 2025-04-17  | 08:00 - 09:00      | 60                  | Abela Kodra   | Started Markdown documentation, conducted tests with 10,000 entries          |
| 2025-04-17  | 09:00 - 09:30      | 30                  | Luiz Marku    | Cleaned up test data, updated README.md                                      |

> Note: This log is updated regularly. Please add changes and new entries in chronological order.
