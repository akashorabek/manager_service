create table "products"(
                           "id" SERIAL NOT NULL,
                           "name" varchar NOT NULL ,
                           "quantity" int NOT NULL ,
                           "purchase_price" numeric CHECK (purchase_price > 0) NOT NULL ,
                           "selling_price" numeric CHECK (selling_price > 0) NOT NULL ,
                           "in_stock" boolean NOT NULL
)
