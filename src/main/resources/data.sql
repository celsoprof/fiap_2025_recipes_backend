-- noinspection SqlNoDataSourceInspectionForFile

--  CADASTRO DE CATEGORIAS
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME) VALUES (1, 'Chicken')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME) VALUES (2, 'Beef')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME) VALUES (3, 'Fish')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME) VALUES (4, 'Bakery')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME) VALUES (5, 'Vegetable')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME) VALUES (6, 'Massa')

--  CADASTRO DE RECEITAS
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id) VALUES (1, 'Torta de frango','PRATO TIPICAMENTE BRASILEIRO','ADVANCED', 240, 1)
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id) VALUES (2, 'Coxinha brasileira','PRATO REFRESCANTE E SAUDÁVEL','BEGGINER', 60, 1)
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id) VALUES (3, 'MACARRONADA','PRATO TÍPICO PARA SERVIR AOS DOMINGOS','INTERMEDIATE', 120, 6)

--  ESTA INSTRUÇÃO É IMPORTANTE PARA QUE OS PRÓXIMOS REGISTROS COMECEM COM 4
    ALTER TABLE tbl_recipe ALTER COLUMN ID RESTART WITH 4

-- CADASTRO DE INGREDIENTES
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (1, '1 colher de sopa de manteiga', 1)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (2, '2 xícaras de farinha de trigo', 1)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (3, '1/2 Kg de frango cozido e picado', 1)

    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (4, '1 Kg de macarrão parafuso', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (5, '100 gr de pimenta do reino', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (6, '200 gr de massa de tomate', 1)

    ALTER TABLE tbl_ingredient ALTER COLUMN ID RESTART WITH 7