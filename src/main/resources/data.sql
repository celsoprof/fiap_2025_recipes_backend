-- noinspection SqlNoDataSourceInspectionForFile

--  CADASTRO DE CATEGORIAS
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL, COLOR) VALUES (1, 'Chicken', '/images/chicken.png', 'FFABF2E9')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL, COLOR) VALUES (2, 'Beef', '/images/beef.png', 'FFF4D6C0')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL, COLOR) VALUES (3, 'Fish', '/images/fish.png', 'FFC6DAFA')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL, COLOR) VALUES (4, 'Bakery', '/images/bakery.png', 'FFF8D9D9')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL, COLOR) VALUES (5, 'Vegetable', '/images/vegetable.png', 'FFABF2E9')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL, COLOR) VALUES (6, 'Drink', '/images/drink.png', 'FF80DEEA')
    INSERT INTO tbl_category(CATEGORY_ID, CATEGORY_NAME, URL, COLOR) VALUES (7, 'Dessert', '/images/dessert.png', 'FF72412B')
    ALTER TABLE tbl_category ALTER COLUMN CATEGORY_ID RESTART WITH 8

--  CADASTRO DE RECEITAS
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id, creation_date, url) VALUES (1, 'Torta de frango','Essa receita de torta de frango de liquidificador é deliciosa e muito prática para o dia a dia.','ADVANCED', 60, 1, '2025-10-05', '/images/torta_de_frango.jpg')
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id, creation_date, url) VALUES (2, 'Bolo de cenoura','Confira essa clássica receita de bolo de cenoura simples e fácil, nossa campeã de acessos!','BEGINNER', 40, 7, '2025-09-05', '/images/bolo_de_cenoura.jpg')
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id, creation_date, url) VALUES (3, 'Salada de berinjela','A salada de berinjela é uma opção saborosa e saudável para os amantes da culinária mediterrânea.','INTERMEDIATE', 30, 5, '2025-10-03', '/images/salada_de_berinjela.jpg')
    INSERT INTO tbl_recipe (ID, TITLE, DESCRIPTION, DIFFICULT_LEVEL, COOKING_TIME, category_category_id, creation_date, url) VALUES (4, 'Strogonoff de frango','O strogonoff de frango é um prato amado por todos e muito fácil de ser preparado!','INTERMEDIATE', 45, 1, '2025-10-22', '/images/strogonoff_de_frango.jpg')
    ALTER TABLE tbl_recipe ALTER COLUMN ID RESTART WITH 5

-- CADASTRO DE INGREDIENTES
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (1, '500 g de peito de frango sem pele', 1)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (2, '4 colheres (sopa) de óleo', 1)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (3, '1 cebola picada', 1)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (4, '1 xícara (chá) de ervilhas', 1)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (5, '1/2 litro de caldo de galinha', 1)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (6, '3 tomates sem pele e sem sementes', 1)

    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (7, '1/2 xícara (chá) de óleo', 2)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (8, '3 cenouras médias raladas', 2)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (9, '4 ovos', 2)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (10, '2 xícaras (chá) de açúcar', 2)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (11, '2 e 1/2 xícaras (chá) de farinha de trigo', 2)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (12, '1 colher (sopa) de fermento em pó', 2)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (13, '3 colheres (sopa) de chocolate em pó', 2)

    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (14, '2 berinjelas grandes cortadas em cubinhos', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (15, '1 dente alho fatiado fino', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (16, '1 cebola cortada em rodelas', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (17, '4 tomates pequenos em rodelas', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (18, '2 pimentões médios cortados em cubos', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (19, '2 colheres de sopa de azeite', 3)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (20, '1 colher de sopa de shoyu ou molho inglês', 3)

    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (21, '1 kg de peito de frango em cubos', 4)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (22, '2 cebolas picadinhas', 4)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (23, '2 tomates picadinhos', 4)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (24, '200 g de champignon', 4)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (25, '1 caixinha de creme de leite', 4)
    INSERT INTO tbl_ingredient (ID, DESCRIPTION, RECIPE_ID) VALUES (26, '2 colheres (sopa) de molho inglês', 4)
    ALTER TABLE tbl_ingredient ALTER COLUMN ID RESTART WITH 27

-- CADASTRO DE MÉTODOS DE PREPARO
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (1, 1, 'Cozinhe o peito de frango no caldo até ficar macio.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (2, 1, 'Separe 1 xícara (chá) de caldo do cozimento e reserve.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (3, 1, 'Refogue os demais ingredientes e acrescente as ervilhas por último.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (4, 1, 'Desfie o frango, misture ao caldo e deixe cozinhar até secar.')

    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (5, 2, 'Em um liquidificador, adicione a cenoura, os ovos e o óleo, depois misture.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (6, 2, 'Acrescente o açúcar e bata novamente por 5 minutos.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (7, 2, 'Em uma tigela ou na batedeira, adicione a farinha de trigo e depois misture novamente.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (8, 2, 'Acrescente o fermento e misture lentamente com uma colher.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (9, 2, 'Asse em um forno preaquecido a 180° C por aproximadamente 40 minutos.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (10, 2, 'Despeje em uma tigela a manteiga, o chocolate em pó, o açúcar e o leite, depois misture.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (11, 2, 'Leve a mistura ao fogo e continue misturando até obter uma consistência cremosa, depois despeje a calda por cima do bolo.')

    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (12, 3, 'Corte as berinjelas em cubinhos e deixe de molho na água com sal por no mínimo 30 minutos para tirar o sabor amargo.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (13, 3, 'Após isso cozinhe as berinjelas até estarem bem macias.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (14, 3, 'Doure no azeite, o alho, a cebola e os pimentões, desligue o fogo e acrescente os tomates, misturando muito bem.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (15, 3, 'Jogue esses ingredientes já prontos na berinjela cozida e escorrida e misture tudo.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (16, 3, 'Esprema o limão, coloque o sal, a pimenta do reino, o orégano e o shoyo.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (17, 3, 'Leve à geladeira por no mínimo 4 horas e sirva com pães ou mesmo durante as refeições.')

    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (18, 4, 'Coloque o óleo em uma panela e frite o frango até quase dourar por completo.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (19, 4, 'Acrescente o conhaque para flambar.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (20, 4, 'Após as chamas apagarem, acrescente a cebola, o tomate e refogue.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (21, 4, 'Acrescente o ketchup, a mostarda, o molho inglês e os champignons.')
    INSERT INTO tbl_preparation_method (ID, RECIPE_ID, DESCRIPTION) VALUES (22, 4, 'Deixe cozinhar por 5 minutos, desligue o fogo e acrescente o creme de leite; mexa bem.')
    ALTER TABLE tbl_preparation_method ALTER COLUMN ID RESTART WITH 23