--Manufacturing (root)
WITH manufacturing AS (
    INSERT INTO sector (name) VALUES ('Manufacturing') RETURNING id)
INSERT
INTO sector (name, parent_id)
VALUES ('Construction materials', (SELECT id FROM manufacturing)),
       ('Electronics and Optics', (SELECT id FROM manufacturing)),
       ('Food and Beverage', (SELECT id FROM manufacturing)),
       ('Furniture', (SELECT id FROM manufacturing)),
       ('Machinery', (SELECT id FROM manufacturing)),
       ('Metalworking', (SELECT id FROM manufacturing)),
       ('Plastic and Rubber', (SELECT id FROM manufacturing)),
       ('Printing', (SELECT id FROM manufacturing)),
       ('Textile and Clothing', (SELECT id FROM manufacturing)),
       ('Wood', (SELECT id FROM manufacturing));

-- Others (root)
WITH others AS (
    INSERT INTO sector (name) VALUES ('Others') RETURNING id)
INSERT
INTO sector (name, parent_id)
VALUES ('Creative industries', (SELECT id FROM others)),
       ('Energy technology', (SELECT id FROM others)),
       ('Environment', (SELECT id FROM others));

-- Service (root)
WITH service AS (
    INSERT INTO sector (name) VALUES ('Service') RETURNING id)
INSERT
INTO sector (name, parent_id)
VALUES ('Business services', (SELECT id FROM service)),
       ('Engineering', (SELECT id FROM service)),
       ('Information Technology and Telecommunications', (SELECT id FROM service)),
       ('Tourism', (SELECT id FROM service)),
       ('Translation services', (SELECT id FROM service)),
       ('Transport and Logistics', (SELECT id FROM service));

WITH food_beverage AS (
    SELECT id
    FROM sector
    where name = 'Food and Beverage')
INSERT
INTO sector (name, parent_id)
VALUES ('Bakery & confectionery products', (SELECT id FROM food_beverage)),
       ('Beverages', (SELECT id FROM food_beverage)),
       ('Fish & fish products', (SELECT id FROM food_beverage)),
       ('Meat & meat products', (SELECT id FROM food_beverage)),
       ('Milk & dairy products', (SELECT id FROM food_beverage)),
       ('Other', (SELECT id FROM food_beverage)),
       ('Sweets & snack food', (SELECT id FROM food_beverage));

WITH furniture AS (
    SELECT id
    FROM sector
    where name = 'Furniture')
INSERT
INTO sector (name, parent_id)
VALUES ('Bathroom/sauna', (SELECT id FROM furniture)),
       ('Bedroom', (SELECT id FROM furniture)),
       ('Children’s room', (SELECT id FROM furniture)),
       ('Kitchen', (SELECT id FROM furniture)),
       ('Living room', (SELECT id FROM furniture)),
       ('Office', (SELECT id FROM furniture)),
       ('Other (Furniture)', (SELECT id FROM furniture)),
       ('Outdoor', (SELECT id FROM furniture)),
       ('Project furniture', (SELECT id FROM furniture));

WITH machinery AS (
    SELECT id
    FROM sector
    where name = 'Machinery')
INSERT
INTO sector (name, parent_id)
VALUES ('Machinery components', (SELECT id FROM machinery)),
       ('Machinery equipment/tools', (SELECT id FROM machinery)),
       ('Manufacture of machinery', (SELECT id FROM machinery)),
       ('Maritime', (SELECT id FROM machinery)),
       ('Metal structures', (SELECT id FROM machinery)),
       ('Outdoor', (SELECT id FROM machinery)),
       ('Repair and maintenance service', (SELECT id FROM machinery));

WITH maritime AS (
    SELECT id
    FROM sector
    where name = 'Maritime')
INSERT
INTO sector (name, parent_id)
VALUES ('Aluminium and steel workboats', (SELECT id FROM maritime)),
       ('Boat/Yacht building', (SELECT id FROM maritime)),
       ('Ship repair and conversion', (SELECT id FROM maritime));

WITH metalworking AS (
    SELECT id
    FROM sector
    where name = 'Metalworking')
INSERT
INTO sector (name, parent_id)
VALUES ('Construction of metal structures', (SELECT id FROM metalworking)),
       ('Houses and buildings', (SELECT id FROM metalworking)),
       ('Metal products', (SELECT id FROM metalworking)),
       ('Metal works', (SELECT id FROM metalworking));

WITH metal_works AS (
    SELECT id
    FROM sector
    where name = 'Metal works')
INSERT
INTO sector (name, parent_id)
VALUES ('CNC-machining', (SELECT id FROM metal_works)),
       ('Forgings, Fasteners', (SELECT id FROM metal_works)),
       ('Gas, Plasma, Laser cutting', (SELECT id FROM metal_works)),
       ('MIG, TIG, Aluminum welding', (SELECT id FROM metal_works));

WITH plastic_rubber AS (
    SELECT id
    FROM sector
    where name = 'Plastic and Rubber')
INSERT
INTO sector (name, parent_id)
VALUES ('Plastic processing technology', (SELECT id FROM plastic_rubber)),
       ('Plastic goods', (SELECT id FROM plastic_rubber)),
       ('Packaging', (SELECT id FROM plastic_rubber)),
       ('Plastic profiles', (SELECT id FROM plastic_rubber));

WITH plastic_processing_technology AS (
    SELECT id
    FROM sector
    where name = 'Plastic processing technology')
INSERT
INTO sector (name, parent_id)
VALUES ('Blowing', (SELECT id FROM plastic_processing_technology)),
       ('Moulding', (SELECT id FROM plastic_processing_technology)),
       ('Plastics welding and processing', (SELECT id FROM plastic_processing_technology));

WITH printing AS (
    SELECT id
    FROM sector
    where name = 'Printing')
INSERT
INTO sector (name, parent_id)
VALUES ('Advertising', (SELECT id FROM printing)),
       ('Book/Periodicals printing', (SELECT id FROM printing)),
       ('Labelling and packaging printing', (SELECT id FROM printing));

WITH textile_clothing AS (
    SELECT id
    FROM sector
    where name = 'Textile and Clothing')
INSERT
INTO sector (name, parent_id)
VALUES ('Clothing', (SELECT id FROM textile_clothing)),
       ('Textile', (SELECT id FROM textile_clothing));

WITH wood AS (
    SELECT id
    FROM sector
    where name = 'Wood')
INSERT
INTO sector (name, parent_id)
VALUES ('Other (Wood)', (SELECT id FROM wood)),
       ('Wooden building materials', (SELECT id FROM wood)),
       ('Wooden houses', (SELECT id FROM wood));

WITH information_technology AS (
    SELECT id FROM sector where name = 'Information Technology and Telecommunications')
INSERT
INTO sector (name, parent_id)
VALUES ('Data processing, Web portals, E-marketing', (SELECT id FROM information_technology)),
       ('Programming, Consultancy', (SELECT id FROM information_technology)),
       ('Software, Hardware', (SELECT id FROM information_technology)),
       ('Telecommunications', (SELECT id FROM information_technology));

WITH transport_logistics AS (
    SELECT id
    FROM sector
    where name = 'Transport and Logistics')
INSERT
INTO sector (name, parent_id)
VALUES ('Air', (SELECT id FROM transport_logistics)),
       ('Rail', (SELECT id FROM transport_logistics)),
       ('Road', (SELECT id FROM transport_logistics)),
       ('Water', (SELECT id FROM transport_logistics));


