-- Schema is already created by flyway that creates it for its table schema_version, don't create it forcibly!
-- However, we have to ensure to create the schema if some day we decide to put schema_version somewhere else.

CREATE SCHEMA IF NOT EXISTS players;

CREATE TABLE IF NOT EXISTS players.player (
	player_id	INTEGER PRIMARY KEY,
	team_id	INTEGER,
	first_name  VARCHAR (128) NOT NULL,
	last_name  VARCHAR (128)
);