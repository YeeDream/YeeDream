package 程序设计方法与优化.肯德基点餐系统;

public  abstract class AbstractFood {
    //类别
    protected String kind;
    //数量
    protected int num;
    //价格
    protected float price;
    //合计
    public float totalPrice(){
        return this.num*this.price;
    }
}
