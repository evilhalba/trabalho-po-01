/**
 * Interface que permite manipular um conjunto de loca��es.
 * @author Aline
 */
public interface Locacoes {
    /**
     * Adiciona uma loca��o na rela��o de loca��es.
     * @param l Loca��o a ser inserido.
     */
    public void add(Locacao l);
    
    /**
     * Captura a loca��o com o codigo informado por par�metro.
     * @param codigo Codigo do loca��o a ser capturado.
     * @return Loca��o com o codigo informado ou null caso o codigo n�o for encontrado.
     */
    public Locacao get(int codigo);
    
    /**
     * Captura uma String com as informa�oes da loca��o com o codigo informado por par�metro.
     * @param codigo Codigo da loca��o a ser capturada.
     * @return String com as informa�oes da loca��o com o codigo informado por par�metro 
     * ou null caso o codigo n�o for encontrado.
     */
    public String getInfo(int codigo);
    
    /**
     * Captura uma String com as informa�oes de todas as loca��es.
     * @return String com as informa�oes de todas as loca��es
     * ou null caso n�o exista nenhuma loca��o.
     */
    public String getInfo();
    
    /**
     * Modifica as informa��es da loca��o com o codigo informado por par�metro.
     * @param codigo Codigo da loca��o a ser modificada.
     * @param l Loca��o com as modifica��es.
     * @return True se a loca��o com o codigo informado por par�metro foi modificada ou
     * false caso n�o exista nenhuma loca��o com o codigo informado.
     */
    public boolean set(int codigo, Locacao l);
    
    /**
     * Remove a loca��o com o codigo igual ao informado por par�metro.
     * @param codigo Codigo da loca��o a ser capturada.
     * @return True se a loca��o com o codigo informado por par�metro foi removida ou
     * false caso n�o exista nenhuma loca��o com o codigo informado. 
     */
    public boolean remove(int codigo);
    
    /**
     * Verifica se existe uma loca��o com o codigo informado por par�metro.
     * @param codigo Codigo da loca��o a ser verificada.
     * @return True se uma loca��o com o codigo informado for encontrada ou 
     * false caso n�o exista nenhuma loca��o com o codigo informado.
     */
    public boolean existe(int codigo);    
}