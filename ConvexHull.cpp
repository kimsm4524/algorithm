#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
pair<int,int> ex1;
//Y좌표가 가장 작은 점을 저장하기 위한 선언
bool cmp(const pair<int,int> &a, const pair<int,int> &b)
{
    //Y좌표에 대해 정렬
    return a.second<b.second;
}
bool cmp2(const pair<int,int> &a, const pair<int,int> &b)
{
    //Y좌표가 가장 작은 점과 이루는 각도의 크기에 대한 정렬
    float ta =(float)(a.second-ex1.second)/(float)(a.first+a.second-ex1.first-ex1.second);
    float tb =(float)(b.second-ex1.second)/(float)(b.first+b.second-ex1.first-ex1.second);
    return ta<tb;
}
int main()
{
    int n,m;
    cin>>n>>m;
    //N : N*N 의 크기, M 점의 수
    vector<pair <int,int> > dots;
    //점들의 정보를 저장하는 벡터
    for(int i=0;i<m;i++)
    {
        //각 점들의 정보 입력
        int tempx,tempy;
        cin>>tempx>>tempy;
        dots.push_back(make_pair(tempx,tempy));
    }
    sort(dots.begin(),dots.end(),cmp);
    //Y좌표가 가장 작은 점 찾기
    ex1=dots[0];
    dots.erase(dots.begin());
    //1번 점은 벡터에서 삭제한다.
    sort(dots.begin(),dots.end(),cmp2);
    //1번 점과 이루는 각도에 대해 정렬
    pair<int,int> ex2=dots[0];
    int count =0;
    //다각형 안에 있는 점의 수
    for(int i=1;i<m-1;i++)
    {
        pair<int,int> temp = dots[i];
        int cross;//외적
        cross = (ex2.first-ex1.first)*(temp.second-ex2.second)-(temp.first-ex2.first)*(ex2.second-ex1.second);
        //외적 계산
        if(cross<0)//외적의 크기가 0보다 작다면 180도 미만
        {
            count++;
        }
        else//외적의 크기가 0보다 크다면 180도 이상
        {
            ex1=ex2;
            ex2=temp;
        }
    }
    cout<<m-count<<" "<<count;
    //m-count : 볼록 다각형을 이루는 점의 수, count, 볼록 다각형 안에 포함되는 점의 수
    return 0;
}
