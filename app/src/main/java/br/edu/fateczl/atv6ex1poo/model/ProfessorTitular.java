/*
@author:<Matheus Augusto Marti>
 */

package br.edu.fateczl.atv6ex1poo.model;

public class ProfessorTitular extends Professor{
    private int anosInstituicao;
    private double salario;

    public ProfessorTitular() {
        super();
    }

    @Override
    public double calcSalario() {
        if (this.anosInstituicao >= 5){
            return this.salario * (1 + (0.05 * (int) (anosInstituicao / 5)));
        }
        return this.salario;
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
