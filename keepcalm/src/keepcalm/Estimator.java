package keepcalm;

import java.io.IOException;
import java.util.ArrayList;

public class Estimator {

   FileParser p;
   public static final int NUMBER_OF_INSTANCES = 60;
   private double diff;
   public Estimator(FileParser p) throws IOException {
       this.p = p;
       diff = findMaxDiff();
   }
   public double estimate2(ArrayList<String> newproject, int threshold) {
	   double Dthreshold = threshold/100;
       double neweffort = 0;
       double totalsim = 0;
       double psize;
       double peffort;
       double newprojectsize = Double.parseDouble(newproject.get(15));
       double[] total = new double[NUMBER_OF_INSTANCES];
       double[] sim = new double[NUMBER_OF_INSTANCES];
       ArrayList<String> project;
       for (int i = 1; i <= NUMBER_OF_INSTANCES; i++) {
           project = p.getInstance(i);
           double tempSim = similarity(newproject, project);
           if(tempSim >= Dthreshold){
               sim[i-1] = tempSim;
               totalsim += sim[i-1];
               psize = Double.parseDouble(project.get(15));
               peffort = Double.parseDouble(project.get(16));
               total[i-1] = (newprojectsize/psize)*peffort;
           }
       }
       for(int i=0; i < sim.length; i++){
        
               neweffort += (sim[i]/totalsim)*total[i];
       }
       return neweffort;
   }
   public  double similarity(ArrayList<String> project1, ArrayList<String> project2) {
		double top = 0;
		for(int i = 0; i != 15; ++i){
			if( project1.get(i).equals(project2.get(i)) ){
				top += 0;
			}else{
				top += 5;
			}
					
		}
		top += Math.pow((Math.abs(Double.parseDouble(project1.get(15)) - Double.parseDouble(project2.get(15))) )/diff, 2);
		return 1-Math.sqrt(top/16);
	}
   private double delta(double d1, double d2){	
		return (Math.abs(d1 -d2)/5)*(Math.abs(d1 -d2)/5);
	}
   private double findMaxDiff(){
		double min = Double.parseDouble(p.getInstance(1).get(16));
		double max = Double.parseDouble(p.getInstance(1).get(16));
		for(int i = 1; i <= NUMBER_OF_INSTANCES; ++i){
			if(max  < Double.parseDouble(p.getInstance(i).get(16)) ){
				max = Double.parseDouble(p.getInstance(i).get(16));
			}
			if(min  > Double.parseDouble(p.getInstance(i).get(16)) ){
				min = Double.parseDouble(p.getInstance(i).get(16));
			}
		}
		
		return max-min;
	}
   private int intValue(String s1){
		if(s1.equals("Very_Low")){
			return 0;
		}else if(s1.equals("Low")){
			return 1;
		}else if(s1.equals("Nominal")){
			return 2;
		}else if(s1.equals("High")){
			return 3;
		}else if(s1.equals("Very_High")){
			return 4;
		}else if(s1.equals("Extra_High")){
			return 5;
		}
		System.out.println("fel :O " + s1);
		return -1;
	}
   
   public double similarity2(ArrayList<String> project1, ArrayList<String> project2){
	   double wantSQRT = 0;
	   for(int i = 0; i < 15; i++){
		   wantSQRT += Math.abs( intValue(project1.get(i))-intValue(project2.get(i)) );   
	   }
	   wantSQRT += (Math.abs(Double.parseDouble(project1.get(15)) - Double.parseDouble(project2.get(15))) );
	   return 1-Math.sqrt(wantSQRT)/16;
	}
   
   public double estimate(ArrayList<String> newproject, int threshold) {
       double doubleThreshold = ((double)threshold/100);
       double neweffort = 0;
       double totalsim = 0;
       double psize;
       double peffort;
       double newprojectsize = Double.parseDouble(newproject.get(15));
       ArrayList<Double> total = new ArrayList<Double>();
       ArrayList<Double> sim = new ArrayList<Double>();
       ArrayList<String> project;
       int nbrOfSimilarities = 0;
       for (int i = 1; i <= NUMBER_OF_INSTANCES; i++) {
           project = p.getInstance(i);
           double tempSim = similarity(newproject, project);
           if (tempSim >= doubleThreshold) {
               sim.add(tempSim);
               totalsim += tempSim;
               psize = Double.parseDouble(project.get(15));
               peffort = Double.parseDouble(project.get(16));
               total.add((newprojectsize / psize) * peffort);
               nbrOfSimilarities++;
           }
       }
       for (int i = 0; i < nbrOfSimilarities; i++) {
//            System.out.println("Sim i: " + sim.get(i) + "totalsim: " + totalsim + "total i " + total.get(i));
           neweffort += (sim.get(i) / totalsim) * total.get(i);
       }
       //System.out.println(nbrOfSimilarities);
       return neweffort;
   }
}
