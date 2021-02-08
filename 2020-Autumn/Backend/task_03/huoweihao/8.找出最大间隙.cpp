#include<iostream>
using namespace std;
int MAX(int a, int b)
{
	return a >= b ? a : b;
}
int MIN(int a, int b)
{
	return a <= b ? a : b;
}
int maximumGap(int* nums, int length) {
	if (length < 2)
		return 0;

	//��ԭ����������Сֵ
	int max = nums[0], min = nums[0];
	for (int i = 1; i < length; i++)
	{
		max = (max >= nums[i] ? max : nums[i]);
		min = (min <= nums[i] ? min : nums[i]);
	}
	if (max == min)
		return 0;


	//����length+1��Ͱ
	int* maxs = new int[length + 1]{};//��¼ÿ��Ͱ�е������
	int* mins = new int[length + 1]{};//��¼ÿ��Ͱ�е���С��
	bool* has = new bool[length + 1]{ 0 };//��¼Ͱ���Ƿ�����


	for (int i = 0; i < length; i++)
	{
		int ID = (nums[i] - min) * length / (max - min);//���ԭ����ĳ��Ԫ�صĶ�ӦͰ���
		maxs[ID] = has[ID] ? MAX(nums[i], maxs[i]) : nums[i];//����Ͱ�����ֵ����ֵ
		mins[ID] = has[ID] ? MIN(nums[i], maxs[i]) : nums[i];//����Ͱ�����ֵ���Сֵ
		has[ID] = 1;
	}


	int maxgap = 0;//��¼����϶
	int lastmax;//��¼��һ����Ͱǰ�ķǿ�Ͱ�����ֵ
	int i = 1;
	while (i < length + 1)//�������еĿ�Ͱ����
	{
		if (has[i] == 0)
		{
			lastmax = maxs[i - 1];
			i++;
			while (has[i] == 0)//��ֹһ����Ͱ�����ж��������Ͱ
				i++;
			if (mins[i] - lastmax > maxgap)
				maxgap = mins[i] - lastmax;
		}
		i++;
	}
	delete[] maxs, mins, has;
	return maxgap;
}
int main()
{
	return 0;
}