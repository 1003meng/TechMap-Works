#include <iostream>
#include <cmath>
using namespace std;
int countGoodTriplets(int* arr,int length,int a,int b,int c)
{
	int i,j,k;
	int count=0;
	for(int i=0;i<length-2;i++)	
	{
		for(int j=i+1;j<length-1;j++)
		{
			for(int k=j+1;k<length;k++)
			if(abs(arr[i]-arr[j])<=a&&abs(arr[j]-arr[k])<=b&&abs(arr[i]-arr[k])<=c)
			count++;
		}
	}
	return count;
}
int main()

{
	cout << "******����Ϊ��������******" << endl; 
	int*arr,length;
	arr=new int[length];
	cout <<"���������鳤�ȣ�"; 
	cin>>length;
	for(int i=0;i<length;i++)
	{
		cin>>arr[i];
	}
	int a,b,c;
	cin>>a>>b>>c;
	cout <<countGoodTriplets( arr,length,a, b,c);
	
}
