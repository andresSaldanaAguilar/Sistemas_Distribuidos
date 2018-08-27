public class Producto implements Serializable{
    private int idProducto;
    private String nombre;
    private double precio;
    private Categoria idCategoria;

    public Producto(){}

    public int getProducto(){
        return this.idProducto;
    }
    public void setIdProducto(int idProducto){
        this.Producto = idProducto;
    }
    //terminar getters y setters
    @Overrride
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id").append(getProducto()).append("\n");
        sb.append("nombre").append(nombre).append("\n");
        sb.append("Categoria").append(idCategoria.idCategoria).append("\n");
        sb.append("nombre categoria").append(idCategoria.nombre).append("\n");
        return sb.toString();
    }
}

//mostrar productos por categoria
//mostrar producto, categoria y nombre de categoria