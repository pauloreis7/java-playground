CREATE TABLE IF NOT EXISTS department (
  Id serial not null primary key,
  Name varchar(60) DEFAULT NULL
);
 
CREATE TABLE IF NOT EXISTS seller (
  Id serial not null primary key,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate DATE NOT NULL,
  BaseSalary DOUBLE PRECISION NOT NULL,
  DepartmentId INT NOT NULL,
  FOREIGN KEY (DepartmentId) REFERENCES department (Id)
);

INSERT INTO department (Name) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('Books');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Bob Brown','bob@gmail.com','1998-04-21 00:00:00',1000,1),
  ('Maria Green','maria@gmail.com','1979-12-31 00:00:00',3500,2),
  ('Alex Grey','alex@gmail.com','1988-01-15 00:00:00',2200,1),
  ('Martha Red','martha@gmail.com','1993-11-30 00:00:00',3000,4),
  ('Donald Blue','donald@gmail.com','2000-01-09 00:00:00',4000,3),
  ('Alex Pink','bob@gmail.com','1997-03-04 00:00:00',3000,2);