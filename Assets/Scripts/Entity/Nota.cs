public class Nota
{
    public int idNota;
    public string nombre;
    public string contenido;
    public int importancia;
    public int fechaDeCreacion;
    public int color;
    public bool archivado;

    public Nota()
    {
        idNota = -1;
        nombre = "nulo";
        contenido = "nulo";
        importancia = 0;
        fechaDeCreacion = 0;
        color = 0;
        archivado = false;
    }

    public Nota(int _id, string _nombre, string _contenido, int _importancia, int _fecha, int _color, bool _archivado)
    {
        idNota = _id;
        nombre = _nombre;
        contenido = _contenido;
        importancia = _importancia;
        fechaDeCreacion = _fecha;
        color = _color;
        archivado = _archivado;
    }
}
