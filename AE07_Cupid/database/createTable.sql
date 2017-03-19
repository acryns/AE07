CREATE TABLE people ( 
person_id int PRIMARY KEY AUTO_INCREMENT, 
firstname VARCHAR(255), 
lastname VARCHAR(255), 
age int, 
street VARCHAR(255), 
zip int, 
city VARCHAR(255), 
gender VARCHAR(10), 
info text, 
note text, 
photo text, 
mail VARCHAR(255) 
)