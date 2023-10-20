package co.edu.upb.oasis;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.JSONClass;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

public class Main {
        public static void main(String[] args) {
                //JSONClass pediClass = new JSONClass<>("pedidos.json", Pedido.class);
                //Cliente cliente = new Cliente("Alex", "Cra 27-50", "Floridablanca", 41764714);
                //pediClass.guardarDaticosEnArchivo();
                /*     
                 * JSONClass pedidJsonClass = new JSONClass<>("pedidos.json", Pedido.class);
                 * JSONClass menuJsonClass = new JSONClass<>("menu.json", Producto.class);
                 * 
                 * pedidJsonClass.cargarJson();
                 * menuJsonClass.cargarJson();
                 * clienJsonClass.cargarJson();
                 * 
                 * DoubleLinkedList<Cliente> cLinkedList = clienJsonClass.obtenerLista();
                 * DoubleLinkedList<Producto> menuList = menuJsonClass.obtenerLista();
                 * System.out.println(menuList.get());
                 * DoubleLinkedList<Producto> items = new DoubleLinkedList<>();
                 * items.add(menuList.get());
                 * Pedido pedido = new Pedido(cLinkedList.get(), items);
                 * 
                 * pedidJsonClass.agregarObjetico(pedido);
                 */

                /*
                 * Producto pescadoALaSal = new Producto("Pescado a la Sal",
                 * "Un método de cocinar pescado, como la dorada o el lubina, cubierto de sal y cocido al horno, manteniendo la carne tierna y sabrosa."
                 * ,
                 * 1500, 12, 1);
                 * Producto paella = new Producto("Paella",
                 * "Un plato de arroz originario de España, cocinado con azafrán y una variedad de ingredientes, como mariscos, pollo, conejo y verduras."
                 * ,
                 * 1800, 5, 2);
                 * Producto kebabs = new Producto("Kebabs",
                 * "Brochetas de carne, como cordero, pollo o ternera, aderezadas con especias y asadas a la parrilla."
                 * ,
                 * 1200, 6, 3);
                 * Producto ratatouille = new Producto("Ratatouille",
                 * "Un guiso provenzal que incluye berenjenas, calabacines, tomates, pimientos y hierbas aromáticas."
                 * ,
                 * 1900, 5, 4);
                 * Producto couscous = new Producto("Couscous",
                 * "Originario del Magreb, el couscous es una sémola de trigo durum cocida al vapor, a menudo servida con verduras y carne."
                 * ,
                 * 1400, 10, 5);
                 * Producto moussaka = new Producto("Moussaka",
                 * "Un plato griego en capas que combina berenjenas, carne picada (generalmente cordero o res), tomate y una bechamel."
                 * ,
                 * 2000, 5, 6);
                 * Producto sangria = new Producto("Sangría",
                 * "Una bebida española refrescante hecha de vino tinto, frutas y un toque de brandy"
                 * , 1500, 5, 7);
                 * Producto cafeGriego = new Producto("Café Griego",
                 * "Un café fuerte y aromático servido en Grecia, a menudo endulzado y sin leche."
                 * , 1700, 8, 8);
                 * Producto ayran = new Producto("Ayran",
                 * "Una bebida turca a base de yogur, agua y sal, muy refrescante en climas cálidos."
                 * , 1600, 6, 9);
                 * Producto aguaDeValencia = new Producto("Agua de Valencia",
                 * "Un cóctel valenciano hecho con zumo de naranja, cava, vodka y ginebra.",
                 * 1100, 4, 10);
                 * Producto cafeEspresso = new Producto("Café Espresso",
                 * "Una taza pequeña pero fuerte de café, típica de Italia, servida en todo el Mediterráneo."
                 * , 1900, 7,
                 * 11);
                 * Producto limoncello = new Producto("Limoncello",
                 * "Un licor italiano de limón, dulce y refrescante, perfecto como digestivo.",
                 * 1200, 9, 12);
                 * Producto baklava = new Producto("Baklava",
                 * "Un postre griego y turco hecho de capas de nueces y masa filo empapadas en miel."
                 * , 1500, 7, 13);
                 * Producto tiramisu = new Producto("Tiramisú",
                 * "Un postre italiano con capas de bizcocho empapado en café, crema de mascarpone y cacao en polvo."
                 * ,
                 * 1400, 8, 14);
                 * Producto cannoli = new Producto("Cannoli",
                 * "Tubos de masa crujiente rellenos de ricotta endulzada, típicos de Sicilia.",
                 * 1600, 10, 15);
                 * Producto pastelDeSantiago = new Producto("Pastel de Santiago",
                 * "Un pastel de almendra español con una cruz de Santiago en la parte superior."
                 * , 1700, 14, 16);
                 * Producto budinDePan = new Producto("Budín de Pan",
                 * "Un postre común en toda la región, hecho de pan viejo empapado en leche y huevo."
                 * , 1800, 7, 17);
                 * Producto loukoumades = new Producto("Loukoumades",
                 * "Bolitas fritas de masa esponjosa cubiertas de miel y nueces, comunes en Grecia y otras partes del Mediterráneo."
                 * ,
                 * 1900, 9, 18);
                 * 
                 * menu.agregarObjetico(pescadoALaSal);
                 * menu.agregarObjetico(paella);
                 * menu.agregarObjetico(kebabs);
                 * menu.agregarObjetico(ratatouille);
                 * menu.agregarObjetico(couscous);
                 * menu.agregarObjetico(moussaka);
                 * menu.agregarObjetico(sangria);
                 * menu.agregarObjetico(cafeGriego);
                 * menu.agregarObjetico(ayran);
                 * menu.agregarObjetico(aguaDeValencia);
                 * menu.agregarObjetico(cafeEspresso);
                 * menu.agregarObjetico(limoncello);
                 * menu.agregarObjetico(baklava);
                 * menu.agregarObjetico(tiramisu);
                 * menu.agregarObjetico(cannoli);
                 * menu.agregarObjetico(pastelDeSantiago);
                 * menu.agregarObjetico(budinDePan);
                 * menu.agregarObjetico(loukoumades);
                 */

                // Puedes acceder a los objetos Producto y sus atributos según tus necesidades

                // archivoClientes.guardarDaticosEnArchivo();
                /*
                 * JSONClass archivoUsuarios = new JSONClass("usuarios.json", Usuario.class);}
                 * 
                 * Usuario operador1 = new Usuario("operador1","1234",101);
                 * Usuario operador2 = new Usuario("operador2","1234",102);
                 * Usuario operador3 = new Usuario("operador3","1234",103);
                 * Usuario operador4 = new Usuario("operador4","1234",104);
                 * Usuario admin = new Usuario("admin","1234",201);
                 * Usuario cocina = new Usuario("cocina","1234",301);
                 * Usuario domicilio = new Usuario("domicilio","1234",401);
                 * 
                 * 
                 * archivoUsuarios.agregarObjetico(operador1);
                 * archivoUsuarios.agregarObjetico(operador2);
                 * archivoUsuarios.agregarObjetico(operador3);
                 * archivoUsuarios.agregarObjetico(operador4);
                 * archivoUsuarios.agregarObjetico(admin);
                 * archivoUsuarios.agregarObjetico(cocina);
                 * archivoUsuarios.agregarObjetico(domicilio);
                 * 
                 * archivoUsuarios.guardarDaticosEnArchivo();
                 */
        }
}