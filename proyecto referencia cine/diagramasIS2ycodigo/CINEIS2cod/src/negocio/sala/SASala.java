package negocio.sala;

public interface SASala {
    public int create(TSala tSala);
    public int update(TSala tSala);
    public boolean delete(int id);
    public TSala read(int id);
    public TSala[] readAll();  
}