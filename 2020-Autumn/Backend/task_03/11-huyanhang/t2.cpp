#include<iostream>
using namespace std;


int findNumbers(int* nums, int length) {
	return length / 2;
}
int main()
{
	cout << "******����Ϊ��������******" << endl;
	const int length = 5;
	int arr[length] = { 12,345,2,6,7896 };
	cout << "����Ϊ��";
	for (int i = 0; i < length; i++)
	{
		cout << arr[i] << " ";
	}cout << endl;
	int* nums, n;
	n = length;
	nums = new int[n];
	for (int i = 0; i < n; i++)
	{
		nums[i] = arr[i];
	}
	cout << "λ��Ϊż���������У�" << findNumbers(nums, length) << "��";


}
