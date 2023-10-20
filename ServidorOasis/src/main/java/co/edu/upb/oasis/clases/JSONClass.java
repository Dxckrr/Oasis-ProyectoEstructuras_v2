package co.edu.upb.oasis.clases;


import java.io.*;
import java.util.Iterator;



import com.google.gson.*;

import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;

public class JSONClass<T extends Serializable> implements Serializable{
    DoubleLinkedList<T> listaObjetos;
    DoubleLinkedList<T> listaObjetosEnElJson;
    private final String nombreArchivoJson;
    private final Class<T> inClass;

    public JSONClass(String nombreArchivoJson, Class inClass) {
        this.nombreArchivoJson = nombreArchivoJson;
        this.listaObjetos = new DoubleLinkedList<>();
        listaObjetosEnElJson = new DoubleLinkedList<>();
        this.inClass = inClass;
    }

    public void cargarJson() {
        File file = new File(nombreArchivoJson);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuilder jsonText = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    jsonText.append(line);
                }
                bufferedReader.close();

                Gson gson = new Gson();
                JsonArray jsonArray = JsonParser.parseString(jsonText.toString()).getAsJsonArray();

                for (JsonElement jsonElement : jsonArray) {
                    T objeto = gson.fromJson(jsonElement, inClass);
                    listaObjetos.add(objeto);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void guardarDaticosEnArchivo() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonArray = new JsonArray();
        Iterator<NodeInterface<T>> iterator = listaObjetos.iterator();
        T temp;
        while (iterator.hasNext()) {
            temp = iterator.next().getObject();
            // System.out.println(temp);
            jsonArray.add(gson.toJsonTree(temp, inClass));
        }
        try (FileWriter fileWriter = new FileWriter(nombreArchivoJson)) {
            fileWriter.write(gson.toJson(jsonArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DoubleLinkedList<T> obtenerLista() {
        return listaObjetos;
    }

    public T obtenerObjeticoPorId(int id) {
        Iterator iterator = listaObjetos.iterator();
        DoubleListNode node;
        T objeto;
        while (iterator.hasNext()) {
            node = (DoubleListNode) iterator.next();
            objeto = (T) node.getObject();
            if (objeto instanceof IdentificarID && ((IdentificarID) objeto).getId() == id) {
                return objeto;
            }
        }
        return null;
    }

    public void agregarObjetico(T objeto) {
        listaObjetos.add(objeto);
        guardarDaticosEnArchivo();
    }

    public void actualizarObjetico(T objetoNuevo, T objetoAntiguo) {
        Iterator iterator = listaObjetos.iterator();
        DoubleListNode node;
        T objeto;
        while (iterator.hasNext()) {
            node = (DoubleListNode) iterator.next();
            objeto = (T) node.getObject();
            if (objeto == objetoAntiguo) {
                node.setObject(objetoNuevo);
                guardarDaticosEnArchivo();
                return;
            }
        }
    }

    public void eliminarObjeto(T object) {
        listaObjetos.remove(object);
        guardarDaticosEnArchivo();
    }

    public boolean validarExistenciaEnElArchivo(T object) {
        return listaObjetos.contains(object);
    }

    public void fusionarArchivos(String otroJsonFileName) {
        try {
            String otroJsonText = leerArchivo(otroJsonFileName);
            JsonArray otroJsonArray = JsonParser.parseString(otroJsonText).getAsJsonArray();

            for (JsonElement jsonElement : otroJsonArray) {
                T objeto = new Gson().fromJson(jsonElement, inClass);
                listaObjetos.add(objeto);
            }

            guardarDaticosEnArchivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface IdentificarID {
        int getId();
    }

    private String leerArchivo(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        File file = new File(fileName);

        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
            bufferedReader.close();
        }

        return content.toString();
    }
}
