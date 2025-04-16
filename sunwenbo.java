//创建一个“部门”类
//“类”属性有部门编号，部门名称以及部门位置
//这个部门中还包含了很多雇员
class Dept{
 private int deptno;
 private String dname;
 private String loc;
 private Emp emps[];
 public Dept(int deptno,String dname,String loc){
  this.deptno=deptno;
  this.dname=dname;
  this.loc=loc;
 }
 public void setDeptno(int deptno){
  this.deptno=deptno;
 }
 public void setDname(String dname){
  this.dname=dname;
 }
 public void setLoc(String loc){
  this.loc=loc;
 }
 public void setEmps(Emp[] emps){
  this.emps=emps;
 }
 public int getDeptno(){
  return this.deptno;
 }
 public String getDname(){
  return this.dname;
 }
 public String getLoc(){
  return this.loc;
 }
 public Emp[] getEmps(){
  return this.emps;
 }
 public String getInfo(){
  return "部门编号："+this.deptno+"\t部门名称："+this.dname+"\t部门位置："+this.loc;
 }
}
//创建一个“雇员”类
//“雇员”属性有雇员编号，姓名，职位，工资以及佣金
//每个雇员有对应的部门，有0个或者1个领导
class Emp{
 private int empno;
 private String ename;
 private String job;
 private double sal;
 private double comm;
 private Emp mgr;
 private Dept dept;
 public Emp(int empno,String ename,String job,double sal,double comm){
  this.empno=empno;
  this.ename=ename;
  this.job=job;
  this.sal=sal;
  this.comm=comm;
 }
 public void setEmpno(int empno){
  this.empno=empno;
 }
 public void setEname(String ename){
  this.ename=ename;
 }
 public void setJob(String job){
  this.job=job;
 }
 public void setSal(double sal){
  this.sal=sal;
 }
 public void setComm(double comm){
  this.comm=comm;
 }
 public void setMgr(Emp mgr){
  this.mgr=mgr;
 }
 public void setDept(Dept dept){
  this.dept=dept;
 }
 public int getEmpno(){
  return this.empno;
 }
 public String getEname(){
  return this.ename;
 }
 public String getJob(){
  return this.job;
 }
 public double getSal(){
  return this.sal;
 }
 public double getComm(){
  return this.comm;
 }
 public Emp getMgr(){
  return this.mgr;
 }
 public Dept getDept(){
  return this.dept;
 }
 public String getInfo(){
  return "雇员编号："+this.empno+"\t姓名："+this.ename+"\t职位："+this.job+"\t工资："+this.sal+"\t佣金"+this.comm;
 }
}
//先建立一个部门
//再建立三个雇员
//ea的领导是eb，eb的领导是ec
//ea，eb，ec的部门都是dept
//dept中有雇员ea，eb，ec
//输出雇员ea的信息，ea的领导信息，ea的部门信息
//在dept部门中输出所有雇员的信息，如果雇员有领导则输出领导的信息
public class Testdemo{
 public static void main(String args[]){
  Dept dept=new Dept(10,"ACCOUNTING","NEW YORK");
  Emp ea=new Emp(7369,"SMITH","CLERK",800,0);
  Emp eb=new Emp(7902,"FORD","MANAGER",2450,0);
  Emp ec=new Emp(7839,"KING","PRESIDENT",5000,0);
  ea.setMgr(eb);
  eb.setMgr(ec);
  ea.setDept(dept);
  eb.setDept(dept);
  ec.setDept(dept);
  dept.setEmps(new Emp[]{ea,eb,ec});
  System.out.println(ea.getInfo());
  System.out.println("\t|-"+ea.getMgr().getInfo());
  System.out.println("\t|-"+ea.getDept().getInfo());
  System.out.println(dept.getInfo());
  for(int i=0;i<dept.getEmps().length;i++){
   System.out.println("\t|-"+dept.getEmps()[i].getInfo());
   if(dept.getEmps()[i].getMgr()!=null){
    System.out.println("\t\t|-"+dept.getEmps()[i].getMgr().getInfo());
   }
  }
 }
}
/**输出结果如下：
 雇员编号：7369  姓名：SMITH     职位：CLERK     工资：800.0     佣金0.0
   |-雇员编号：7902        姓名：FORD      职位：MANAGER   工资：2450.0    佣金0.0
   |-部门编号：10  部门名称：ACCOUNTING    部门位置：NEW YORK
 部门编号：10    部门名称：ACCOUNTING    部门位置：NEW YORK
   |-雇员编号：7369        姓名：SMITH     职位：CLERK     工资：800.0     佣金0.0
     |-雇员编号：7902        姓名：FORD      职位：MANAGER   工资：2450.0    佣金0.0
   |-雇员编号：7902        姓名：FORD      职位：MANAGER   工资：2450.0    佣金0.0
     |-雇员编号：7839        姓名：KING      职位：PRESIDENT 工资：5000.0    佣金0.0
   |-雇员编号：7839        姓名：KING      职位：PRESIDENT 工资：5000.0    佣金0.0
*/