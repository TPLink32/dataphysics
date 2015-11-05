package com.dataphysics.basequantity;

public class BaseQuantities {
    private int clusterMassNum = 1;//质量数量
    private int clusterMass = 1;//质量
    private int clusterEle = 0;//电荷

    private int objectMass = 0;//物质质量
    private int objectEle = 0;//物质电荷
    private double[] objectCore = new double[]{0,0,0};//物质重心坐标
    private double[] objectForce = new double[]{0,0};//物质力

    public BaseQuantities() {}
    public BaseQuantities(int mass, int ele, double[] core,double[] force ) {
        objectMass = mass;
        objectEle = ele;
        objectCore = core;
        objectForce = force;
    }
    public void setObjectMass(int mass) {
        this.objectMass = mass;
    }
    public int getObjectMass() {
        return this.objectMass;
    }
    public void setObjectEle(int ele) {
        this.objectEle = ele;
    }
    public int getObjectEle() {
        return this.objectEle;
    }
    public void setObjectCore(double[] core) {
        this.objectCore = core;
    }
    public double[] getObjectCore() {
        return this.objectCore;
    }
    public void setObjectForce(double repulsion, double attraction) {
        this.objectForce[0] = repulsion;
        this.objectForce[1] = attraction;
    }
    public double[] getObjectForce() {
        return this.objectForce;
    }
}
/*
package com.dataphysics.basequantity;

public class BaseQuantities {
    private int clusterMassNum = 1;//质量数量
    private int clusterMass = 1;//质量
    private int clusterEle = 0;//电荷
    public int mass;
    public int ele;
    public double[] core;
    public double[] force;
    public int getMass() {
        return new Mass().getObjectMass();
    }
    public int getElectricity() {
        return new Electricity().getObjectEle();
    }
    public double[] getCore() {
        return new Core().getObjectCore();
    }
    public double[] getForce() {
        return new Force().getObjectForce();
    }
    public BaseQuantities() {
        initialize();
    }
    public BaseQuantities(int mass, int ele,double[] core, double[] force) {
        new Mass().setObjectMass(mass);
        new Electricity().setObjectEle(ele);
        new Core().setObjectCore(core);
        new Force().setObjectForce(force[0], force[1]);
    }
    private void initialize() {
        new Mass().setObjectMass(1);
        new Electricity().setObjectEle(0);
        new Core().setObjectCore(new double[]{0, 0, 0});
        new Force().setObjectForce(0, 0);
    }
//    private int eMassNum = 1;//电子数量
//    private int neuMassNum = 1;//中子数量
//    private int atomMassNum = 1;//原子数量
//
//    private int eMass = 0;//电子质量
//    private int neuMass = 1;//中子质量
//    private int atomMass = 1;//中子质量
//

//
//    private int clusterEleNum = 0;//电荷数量
//
//    private int eEleNum = 1;//电子数量
//    private int neuEleNum = 0;//中子数量
//    private int atomEleNum = 1;//原子数量
//
//    private int eEle = -1;//电子电荷
//    private int neuEle = 0;//中子电荷
//    private int atomEle = 1;//原子电荷
//    private int[] eCore = new int[3];//原子重心坐标
//    private int[] beuCore = new int[3];//中子重心坐标
//    private int[] atomCore = new int[3];//原子重心坐标
//    private int[] clusterCore = new int[3];//重心坐标
//
//    private double repulsion = 0;//斥力
//    private double attraction = 0;//引力
}

class Mass {
    private int objectMass = 0;//物质质量
    public void setObjectMass(int mass) {
        this.objectMass = mass;
    }
    public int getObjectMass() {
        return this.objectMass;
    }
}//物质的重量
class Electricity {
    private int objectEle = 0;//物质电荷
    public void setObjectEle(int ele) {
        this.objectEle = ele;
    }
    public int getObjectEle() {
        return this.objectEle;
    }
}//物质的电荷
class Core {
    private double[] objectCore = new double[3];//物质重心坐标
    public void setObjectCore(double[] core) {
        this.objectCore = core;
    }
    public double[] getObjectCore() {
        return this.objectCore;
    }
}//物质的重心
class Force {
    private double[] objectForce = new double[2];//物质力
    public void setObjectForce(double repulsion, double attraction) {
        this.objectForce[0] = repulsion;
        this.objectForce[1] = attraction;
    }
    public double[] getObjectForce() {
        return this.objectForce;
    }
}//物质的力*/
