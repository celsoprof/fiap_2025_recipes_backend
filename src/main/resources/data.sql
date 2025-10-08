-- noinspection SqlNoDataSourceInspectionForFile

--  CADASTRO DE CATEGORIAS
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL) VALUES (1, 'Chicken', '/images/chicken.png')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL) VALUES (2, 'Beef', '/images/beef.png')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL) VALUES (3, 'Fish', '/images/fish.png')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL) VALUES (4, 'Bakery', '/images/bakery.png')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL) VALUES (5, 'Vegetable', '/images/vegetable.png')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL) VALUES (6, 'Drink', '/images/drink.png')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL) VALUES (7, 'Dessert', '/images/dessert.png')
    ALTER TABLE tbl_category ALTER COLUMN CATEGORY_ID RESTART WITH 8

--  CADASTRO DE RECEITAS
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id, creation_date) VALUES (1, 'Torta de frango','PRATO TIPICAMENTE BRASILEIRO','ADVANCED', 240, 1, '2025-10-05')
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id, creation_date) VALUES (2, 'Coxinha de frango','Pare de desejar a coxinha de frango da lanchonete da esquina e faça a sua própria!','BEGGINER', 30, 1, '2025-09-05')
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id, creation_date) VALUES (3, 'MACARRONADA','PRATO TÍPICO PARA SERVIR AOS DOMINGOS','INTERMEDIATE', 120, 6, '2025-10-03')
    ALTER TABLE tbl_recipe ALTER COLUMN ID RESTART WITH 4

-- CADASTRO DE INGREDIENTES
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (1, '1 colher de sopa de manteiga', 1)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (2, '2 xícaras de farinha de trigo', 1)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (3, '1/2 Kg de frango cozido e picado', 1)

    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (4, '1 Kg de macarrão parafuso', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (5, '100 gr de pimenta do reino', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (6, '200 gr de massa de tomate', 1)
    ALTER TABLE tbl_ingredient ALTER COLUMN ID RESTART WITH 7

-- CADASTRO DE MÉTODOS DE PREPARO
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (1, 1, 'Cozinhe o peito de frango no caldo até ficar macio.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (2, 1, 'Refogue os demais ingredientes e acrescente as ervilhas por último.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (3, 1, 'Desfie o frango, misture ao caldo e deixe cozinhar até secar.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (4, 3, 'Coloque a água com o sal para ferver.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (5, 3, 'Enquanto isso prepare o molho.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (6, 3, 'Quando a água ferver acrescente o macarrão e deixe por 10 minutos no fogo.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (7, 3, 'Depois escorra o macarrão e lave em água fria.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (8, 3, 'Refoge o macarrão já cozido em 1/2 colher de margarina e depois junte ao molho.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (9, 3, 'Mexa muito bem para todo o macarrão ficar coradinho.')
    ALTER TABLE tbl_preparation_method ALTER COLUMN ID RESTART WITH 10