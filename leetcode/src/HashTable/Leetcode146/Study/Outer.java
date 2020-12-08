package HashTable.Leetcode146.Study;

/**
 * 内部类属性加不加修饰符号比较好呢
 * @author ：hodor007
 * @date ：Created in 2020/12/8
 * @description ：
 * @version: 1.0
 */

/**
 * 成员内部类，就是作为外部类的成员，可以直接使用外部类的所有成员和方法，即使是private的。
 * 同时外部类要访问内部类的所有成员变量/方法，则需要通过内部类的对象来获取。
 * 要注意的是，成员内部类不能含有static的变量和方法。因为成员内部类需要先创建了外部类，才能创建它自己的。
 * 在成员内部类要引用外部类对象时，使用outer.this来表示外部类对象；
 * 创建内部类对象，可以使用outer.inner obj = outerobj.new inner();
 *
 * 作者：海天一树X
 * 链接：https://www.jianshu.com/p/3ec6aa56fe6a
 * 来源：简书
 */
public class Outer {
    public class Inner {
        public void print(String str) {
            System.out.println(str);
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        //要手动创建内部类要先创建外部类
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print("Outer.new");

        inner = outer.getInner();
        inner.print("Outer.get");
    }
}
