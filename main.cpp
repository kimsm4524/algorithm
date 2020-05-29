#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
pair<int,int> ex1;
//Y��ǥ�� ���� ���� ���� �����ϱ� ���� ����
bool cmp(const pair<int,int> &a, const pair<int,int> &b)
{
    //Y��ǥ�� ���� ����
    return a.second<b.second;
}
bool cmp2(const pair<int,int> &a, const pair<int,int> &b)
{
    //Y��ǥ�� ���� ���� ���� �̷�� ������ ũ�⿡ ���� ����
    float ta =(float)(a.second-ex1.second)/(float)(a.first+a.second-ex1.first-ex1.second);
    float tb =(float)(b.second-ex1.second)/(float)(b.first+b.second-ex1.first-ex1.second);
    return ta<tb;
}
int main()
{
    int n,m;
    cin>>n>>m;
    //N : N*N �� ũ��, M ���� ��
    vector<pair <int,int> > dots;
    //������ ������ �����ϴ� ����
    for(int i=0;i<m;i++)
    {
        //�� ������ ���� �Է�
        int tempx,tempy;
        cin>>tempx>>tempy;
        dots.push_back(make_pair(tempx,tempy));
    }
    sort(dots.begin(),dots.end(),cmp);
    //Y��ǥ�� ���� ���� �� ã��
    ex1=dots[0];
    dots.erase(dots.begin());
    //1�� ���� ���Ϳ��� �����Ѵ�.
    sort(dots.begin(),dots.end(),cmp2);
    //1�� ���� �̷�� ������ ���� ����
    pair<int,int> ex2=dots[0];
    int count =0;
    //�ٰ��� �ȿ� �ִ� ���� ��
    for(int i=1;i<m-1;i++)
    {
        pair<int,int> temp = dots[i];
        int cross;//����
        cross = (ex2.first-ex1.first)*(temp.second-ex2.second)-(temp.first-ex2.first)*(ex2.second-ex1.second);
        //���� ���
        if(cross<0)//������ ũ�Ⱑ 0���� �۴ٸ� 180�� �̸�
        {
            count++;
        }
        else//������ ũ�Ⱑ 0���� ũ�ٸ� 180�� �̻�
        {
            ex1=ex2;
            ex2=temp;
        }
    }
    cout<<m-count<<" "<<count;
    //m-count : ���� �ٰ����� �̷�� ���� ��, count, ���� �ٰ��� �ȿ� ���ԵǴ� ���� ��
    return 0;
}
