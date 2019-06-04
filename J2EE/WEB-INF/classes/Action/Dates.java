package Action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class Dates implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int j;
private int m;
private int a;

public Dates(int f,int b,int c)
{j=f;m=b;a=c;}

public Dates(String f,String b,String c)
{j=Integer.parseInt(f) ;m=Integer.parseInt(b);a=Integer.parseInt(c);}

public Dates(Object f,Object b,Object c)
{j=Integer.parseInt((String)f)
 ;m=Integer.parseInt((String)b);a=Integer.parseInt((String)c);}
public Dates(String d)
{String [] t=d.split("/");
j=Integer.parseInt(t[0])
;m=Integer.parseInt(t[1]);a=Integer.parseInt(t[2]);
}
public int getj()
{return j;}
public int getm()
{return m;}
public int geta()
{return a;}

public void setj(int x)
{ j=x;}
public void setm(int x)
{m=x;}
public void seta(int x)
{ this.a=x;}

public boolean bissextile ()
{return (a %4==0&&a%100!=0||a%400==0);}

public int nbjours()
{switch(m)
 {case 1 :case 3: case 5 :case 7: case 8:case 10 :case 12 :return 31;
  case 2 :if (bissextile() ) return 29 ;
  else return 28;
 }
 return 31;
}

public boolean DateValide()
{return ((j>0)&&(j<=nbjours())&&(m>0)&&(m<=12)&&(a>0));}

public Dates demain ()
{Dates d = new Dates (j,m,a);
if (d.j<nbjours())
    d.j++;
  else{
        d.j=1;
        if (d.m<12)
        d.m++;
        else
           {d.m=1;
            d.a++;
            }
      }
return d;
}

public boolean egal(Dates d)
{return d.j==j && d.m==m&&d.a==a;}

public boolean sup(Dates d)
{   if (egal(d)) return false;
    else
    {
    if (a>d.a) return true;
    else if( a==d.a && m>d.m ) return true;
          else { if (a==d.a && m==d.m && j>d.j) return true;
                else return false ;
               }
    }
}
public int diff (Dates d)
{ if (egal(d)) return 0;
 else { if (sup (d))
 { int nb =0;
   Dates d1=new Dates (d.j,d.m,d.a);
   while (!d1.egal(this))
   {d1=d1.demain();
    nb++;
   }
 return nb;
 }
 else { { int nb =0;
   Dates d1=new Dates (j,m,a);
   Dates d2 =new Dates (d.j,d.m,d.a);
   while (!d1.egal(d2))
   {d1=d1.demain();
    nb++;
   }
 return nb;
 }
 }
      }
}

public static Dates actuelle()
{Dates d=new Dates(1,1,9);
 Date dateDuJour = new Date();
SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
String ch =formatter.format(dateDuJour).toString()  ;
int cas = 1;
String ch2;
ch2="";
for (int i = 0 ;i<ch.length();i++)
if (ch.charAt(i)!='-')
{ch2=ch2+  ch.charAt(i);}
else
 {switch (cas)
 {case 1 : d.setj(Integer.parseInt(ch2)  );break;
  case 2 : d.setm(Integer.parseInt(ch2));break;
 }

 if (cas !=3) ch2="";
 cas++;
}
d.seta(Integer.parseInt(ch2));
return d;}

public String toString()
{
return  j+"/"+m+"/"+a ;  }

public static String []jour ()
 {String []t=new String [31];
      for (int i=1;i<=31;i++)
  t[i-1]=String.valueOf(i) ;
return t;}


public static String []mois ()
 {String []t=new String [12];
      for (int i=1;i<=12;i++)
  t[i-1]=String.valueOf(i) ;
return t;}


public static String []annee ()
 {String []t=new String [(Dates.actuelle()).geta()-1900+1];

      for (int i=1900;i<=(Dates.actuelle()).geta();i++)
  t[i-1900]=String.valueOf(i) ;
      for(int i=0;i<t.length /2-1;i++)
      {String aux=t[i];
        t[i]=t[t.length-i-1];
        t[t.length-i-1]=aux;
      }
return t;}

public boolean equals(Dates d)
{return j==d.j&&m==d.m&&a==d.a;}

public static Dates ParseDates(String ch)
    {Dates d=new Dates(1,1,0);
try{
    int cas = 1;
    String ch2="";
    for (int i = 0 ;i<ch.length();i++)
    if (ch.charAt(i)!='/')
    {ch2=ch2+  ch.charAt(i);}
    else
     {switch (cas)
     {case 1 : d.setj(Integer.parseInt(ch2)  );break;
      case 2 : d.setm(Integer.parseInt(ch2));break;
     }

     if (cas !=3) ch2="";
     cas++;
    }
    d.seta(Integer.parseInt(ch2));
}catch (Exception e){}
if(!d.DateValide() ) return new Dates(1,1,0);
int count=0;
for (int i=0;i<ch.length() ;i++)
if (ch.charAt(i)=='/')
  count++;
if((ch.length()!=10 &&ch.length()!=8&&ch.length()!=9)||count!=2)
return new Dates(1,1,0);
else
return d;
}
}