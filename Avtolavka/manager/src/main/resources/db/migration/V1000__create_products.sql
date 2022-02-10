create table "products"(
                           "id" SERIAL NOT NULL,
                           "name" varchar(128) NOT NULL ,
                           "quantity" int NOT NULL ,
                           "purchase_price" float NOT NULL ,
                           "selling_price" float NOT NULL ,
                           "in_stock" boolean NOT NULL
)
