import java.util.*;
class Calculations
{
    public double sum(double arr[])
    {
        double s=0;
        for(double data: arr)
        {
            s+=data;
        }
        return s;
    }
    public double mean(double arr[])
    {
        Calculations ob1=new Calculations();
        double m=ob1.sum(arr)/arr.length;
        return m;
    }
    public double median(double arr[])
    {
        // The data used here has already been sorted using inbuilt sorting algorithm
        Arrays.sort(arr);
        int n= arr.length;
        double med=0;
        if(n%2==0)
        {
            med=(arr[n/2+1]+arr[n/2])/2.0;
        }
        else
        {
            med=arr[(n+1)/2];
        }
        return med;
    }
    public List<Double> mode(double[] data) {
        // Step 1: Initialize a hash map to store the frequency of each element
        Map<Double, Integer> frequencyMap = new HashMap<>();

        // Step 2: Count frequencies
        for (double num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: Find the maximum frequency
        int maxFrequency = Collections.max(frequencyMap.values());

        // Step 4: Identify the mode(s)
        List<Double> modes = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        return modes;
    }
    public double variance(double arr[])
    {
        Calculations ob2=new Calculations();
        double mean= ob2.mean(arr);
        int n=arr.length;
        double sum=0;
        for(int i=0;i< arr.length;i++)
        {
            sum+=Math.pow((arr[i]-mean),2);
        }
        return sum/(arr.length-1);
    }
    public double Standard_deviation(double arr[])
    {
        Calculations ob3=new Calculations();
        double sd=Math.sqrt(ob3.variance(arr));
        return sd;
    }

}
public class Final_version
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("The data of how many persons are to considered...");
        int numPersons = sc.nextInt(); // You can change this to any number as needed
        sc.nextLine();//Newline feed
        Map<String, double[]> personData = new HashMap<>();

        // Input names and their respective data arrays
        for (int i = 0; i < numPersons; i++)
        {
            System.out.println("Enter name of person " + (i + 1) + ":");
            String name = sc.nextLine();

            System.out.println("How many data for " + name + ":");
            int numData = sc.nextInt();
            double[] data = new double[numData];

            System.out.println("Enter the data for " + name + ":");
            for (int j = 0; j < numData; j++) //The data is taken as input from the user
            {
                System.out.format("Data %d :",(j+1));
                data[j] = sc.nextDouble();
            }
            sc.nextLine(); // Newline feed

            personData.put(name, data); //The format in which the hash is stored
        }

        //Accessing the data by the names
        while (true) {
            System.out.println("Enter the name of the person whose data you want to access:");
            String queryName = sc.nextLine();
            if (personData.containsKey(queryName))
            {
                double[] data = personData.get(queryName);
                Calculations obj = new Calculations();
                while(true)
                {
                    System.out.println("What to do with the above data");
                    System.out.println("1...Mean");
                    System.out.println("2...Median");
                    System.out.println("3...Mode");
                    System.out.println("4...Standard Deviation ");
                    System.out.println("5...Variance");
                    System.out.println("6...Change any data");
                    System.out.println("7...Exit    !!(This will terminate the process)");
                    System.out.println("Press any key to proceed");
                    int ch = sc.nextInt();
                    switch (ch)
                    {
                        case 1:
                        {
                            System.out.println("The mean of the given set of data is: " + obj.mean(data));
                            break;
                        }
                        case 2:
                        {
                            System.out.println("The median of the given data is " + obj.median(data));
                            break;
                        }
                        case 3:
                        {
                            List<Double> modes = obj.mode(data);
                            System.out.println("Modes: " + modes);
                            break;
                        }
                        case 4:
                        {
                            System.out.println("The Standard deviation of the given data is " + obj.Standard_deviation(data));
                            break;
                        }
                        case 5:
                        {
                            System.out.println("The variance of the given data is " + obj.variance(data));
                            break;
                        }
                        case 6:
                        {
                            System.out.println("To change the data ");
                            System.out.println("Enter the data which has to be changed ");
                            double d = sc.nextDouble();
                            //THis is used to populate the hash map -->
                            HashMap<Double, Integer> hashMap = new HashMap<>();
                            for (int i = 0; i < data.length; i++)
                            {
                                hashMap.put(data[i], i);
                            }
                            int indx = 0;

                            //First the element is searched using hash map concept in order to reduce the time complexity to O(1)

                            if (hashMap.containsKey(d))
                            {
                                indx = hashMap.get(d);
                                System.out.println("Enter the new value ");
                                data[indx] = sc.nextDouble();
                                System.out.println("The new data in tabular format");
                                System.out.println(Arrays.toString(data));
                            }
                            else
                            {
                                System.out.println("Element not found");
                                //In case the search element is not found
                            }
                            break;

                        }
                        case 7:
                        {
                            System.out.println("Thank you");
                            System.exit(0);
                            break;
                        }
                        default:
                        {
                            System.out.println("INVALID Choice");
                        }
                    }
                }
            }
        }
    }
}
