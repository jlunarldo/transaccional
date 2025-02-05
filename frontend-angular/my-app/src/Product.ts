export interface  Product{
    readonly id:number;
    nameProduct:string;
    category:string;
    priceUnit:number;
    subCategorie?:string;
    flag:number;
    cantTotal?:number;
    priceTotal?:number;
}


//Json que recibo de la base de datos
/*{
    "object": {
         "id_product": 32,
       "nameProduct": "Mouse Logitech",
        "description": "Mouse inalámbrico óptico",
        "categorie": "Electrónica",
         "subCategorie": "Accesorios",
        "cantTotal": 0,
         "priceUnit": 20.99,
         "priceTotal": 0,
         "flag": 1,
         "registerDate": "2025-02-03T02:14:04.000+00:00"
    },
     "list": null
 }*/