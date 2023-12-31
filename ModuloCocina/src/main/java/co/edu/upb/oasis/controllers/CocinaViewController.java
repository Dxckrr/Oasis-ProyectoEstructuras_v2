package co.edu.upb.oasis.controllers;

import java.util.Iterator;

import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.estructuras.queue.PriorityQueue;
import co.edu.upb.oasis.models.ModelCocina;
import co.edu.upb.oasis.vistas.VistaCocina;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CocinaViewController {

    public CocinaViewController() {
        ModelCocina modelCocina = new ModelCocina();
        VistaCocina vistaCocina = new VistaCocina();
        // CREAR OTRA COLA PARA ASI ORGANIZAR LOS PEDIDOS
        PriorityQueue<Producto> mPriorityQueue = new PriorityQueue<>(2);
        PriorityQueue<Producto> mPriorityQueueCopia = new PriorityQueue<>(2);

        // ----------------------------------------------------------------------------
        PriorityQueue<Pedido> pedidosToSend = new PriorityQueue<>(2);
        // --
        // ----------------------------------------------------------------------------
        // creando ANIMACIONES

        EventHandler<MouseEvent> click = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int count = 0;
                for (int i = 0; i < vistaCocina.hornos.length; i++) {
                    if (event.getSource() == vistaCocina.hornos[i].getHorno() && vistaCocina.hornos[i].isOn()) {

                        // Apagar Horno
                        vistaCocina.hornos[i].resetHorno();
                        System.out.println("it worksssssssss");
                        vistaCocina.hornos[i].getHorno().setCursor(Cursor.DEFAULT);

                        // FALTA IMPLEMENTAR LA MANERA DE ENVIAR A DOMICILIO
                        if (!vistaCocina.hornos[i].isOn()) {
                            count++;
                        }
                        if (count == 15) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("PEDIDOS ENVIADOS");
                            alert.setHeaderText("SIGAN");
                            alert.setContentText("Siganle con ganas mi gente!" + "\n" + "A COCINAR...");
                            alert.showAndWait();
                            modelCocina.sendPedidoToDomicilio(pedidosToSend.extract());
                        }

                    }

                }
            }
        };

        vistaCocina.getPedidosButton.setOnAction(actionEvent -> {
            try {
                Pedido inPedido = modelCocina.getPedido();
                Pedido pedidoCopia = inPedido;

                if (inPedido.getCliente().isVip()) {
                    pedidosToSend.add(pedidoCopia, 0);

                } else {
                    pedidosToSend.add(pedidoCopia, 1);

                }
                // -------------------------------------------------

                DoubleLinkedList<Producto> productosEnPedido = inPedido.getProductos();
                System.out.println(productosEnPedido);
                if (!productosEnPedido.isEmpty()) {
                    Iterator<NodeInterface<Producto>> iterator = productosEnPedido.iterator();
                    DoubleListNode<Producto> temp;
                    while (iterator.hasNext()) {
                        temp = (DoubleListNode<Producto>) iterator.next();
                        System.out.println(temp.getObject().getNombre());
                        // String productoTemp = temp.getObject().getNombre();
                        if (temp.getObject().isLento()) {
                            mPriorityQueue.add(temp.getObject(), 0);
                            mPriorityQueueCopia.add(temp.getObject(), 0);
                        } else {
                            mPriorityQueue.add(temp.getObject(), 1);
                            mPriorityQueueCopia.add(temp.getObject(), 1);
                        }
                    }

                    System.out.println(mPriorityQueue.size());
                    while (!mPriorityQueue.isEmpty()) {
                        // System.out.println(z);
                        // System.out.println(mPriorityQueue.extract().getNombre());

                        vistaCocina.items.add(mPriorityQueue.extract().getNombre());
                        System.out.println("------------");
                        // System.out.println(vistaCocina.items.get(z));
                    }
                }

            } catch (Exception e) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("TRANQUILOS");
                alert.setHeaderText("NO HAY MAS PEDIDOS");
                alert.setContentText("Siganle con ganas mi gente!" + "\n" + "A CHAMBEARRRR...");
                alert.showAndWait();

                System.out.println("NO hay MAS PEDIDOS");
            }

            // ---
            // System.out.println(modelCocina.getPedido());
        });

        vistaCocina.cookButton.setOnAction(actionEvent -> {

            Producto temp = mPriorityQueueCopia.extract();
            if (temp != null) {

                for (int j = 0; j < vistaCocina.hornos.length; j++) {
                    if (!vistaCocina.hornos[j].isOn()) {

                        if (temp.isLento() == true) {
                            if (vistaCocina.hornos[j].isLento()) {
                                vistaCocina.hornos[j].turnOnLento();
                                vistaCocina.hornos[j].setProductoCook(temp);
                                vistaCocina.items.remove(temp.getNombre());
                                break;

                            }
                        } else {
                            // SI no es lento entonces
                            if (!vistaCocina.hornos[j].isLento()) {

                                vistaCocina.hornos[j].turnOnRapido();
                                vistaCocina.hornos[j].setProductoCook(temp);
                                vistaCocina.items.remove(temp.getNombre());
                            }

                            break;

                        }
                    }
                }
                for (int i = 0; i < vistaCocina.hornos.length; i++) {
                    if (vistaCocina.hornos[i].isOn()) {
                        vistaCocina.hornos[i].getHorno().setOnMouseClicked(click);
                        vistaCocina.hornos[i].getHorno().setCursor(Cursor.HAND);
                    }
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("TRANQUILOS");
                alert.setHeaderText("NO HAY MAS PRODUCTOS");
                alert.setContentText("Descansen!" + "\n" + "Bien hecho...");
                alert.showAndWait();
            }

        });

    }
};
// REVISAR
