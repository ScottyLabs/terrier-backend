CREATE USER terrier WITH PASSWORD 'terrier';
CREATE DATABASE terrier;
GRANT ALL PRIVILEGES ON DATABASE terrier TO terrier;

\c terrier postgres
GRANT ALL PRIVILEGES ON SCHEMA public TO terrier;