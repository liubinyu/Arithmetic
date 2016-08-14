import java.util.Random;
import java.util.Scanner;

public class Arithmetic
{
    public static void main (String[] args){
        int x,y;//定义运算数值
        int a;//输入的答案
        int d;//正确的答案
        int p=0;//分数
        int g=0;//答对个数
        int m=0;
        String w="";
        System.out.println("请输入出题数量");
        Scanner sl=new Scanner(System.in);
        int zs=sl.nextInt();
        System.out.println("请输入练习数值大小");
        Scanner lx=new Scanner(System.in);
        int size=lx.nextInt();
        long time=System.currentTimeMillis();
        for(int i=0;i<zs;i++){//每次出题个数
            Random r=new Random();//随机运算数值实例
            x=r.nextInt(size);
            y=r.nextInt(size);
            Random l=new Random();//随机运算符号实例
            int f=l.nextInt(4);
            String ysf="";
            if(f==0){
                ysf="+";
                d=x+y;
            }
            else if(f==1){
                ysf="-";
                d=x-y;
                if(d<0){
                    x=y;
                    y=x;
                    d=y-x;
                }
            }
            else if(f==2){
                ysf="×";
                d=x*y;
            }
            else{
                ysf="÷";
                if(y==0&&x!=0){
                    x=y;
                    y=y+1;
                    d=x/y;
                }
                else if(y==0&&x==0){
                    y=y+1;
                    d=x/y;
                }
                d=x/y;
            }
            String bz="";
            if(f==3){
                bz="(只取整数部分,不四舍五入)";
            }
            else{
                bz="";
            }
            System.out.println(x+ysf+y+bz);
            System.out.println("请输入此题答案");
            Scanner s =new Scanner(System.in);
            a=s.nextInt();
            if(a==d){
                System.out.println("-----恭喜回答正确-----");
                p=p+10;
                g=g+1;
                continue;
            }
            else{
                System.out.println("-----很遗憾回答错误-----");
            }
        }
        float tv=(System.currentTimeMillis()-time)/1000f;
        float v;
        v=((float)g/(float)zs)*100;
        if(v>90||v==100){
            w="SMART";
        }
        else if(v>=80&v<=90){
            w="GOOD";
        }
        else if(v>=60&v<80){
            w="PASS";
        }
        else{
            w="TRY AGAIN";
        }
        System.out.println("§总结§");
        System.out.println("执行耗时 : "+tv+" 秒 "+" "+"平均耗时"+tv/(float)zs+"秒");
        System.out.println("答对个数"+g+" "+"总个数"+zs);
        System.out.println("正确率"+v+"%");
        System.out.println("总分"+zs*10+" "+"最终得分:"+p);
        System.out.println("等级:"+w);
    }
}
