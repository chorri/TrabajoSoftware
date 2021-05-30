public class Usuario
{
    public int idUsuario;
    public string nombre;
    public string correo;
    public string contrasena;
    public int fechaDeNacimiento;

    public Usuario()
    {
        idUsuario = -1;
        nombre = "nulo";
        correo = "nulo";
        contrasena = "nulo";
        fechaDeNacimiento = 0;
    }

    public Usuario(int _id, string _nombre, string _correo, string _contrasena, int _fecha)
    {
        idUsuario = _id;
        nombre = _nombre;
        correo = _correo;
        contrasena = _contrasena;
        fechaDeNacimiento = _fecha;
    }
}
