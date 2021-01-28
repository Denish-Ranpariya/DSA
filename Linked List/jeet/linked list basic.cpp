#include<iostream>
#include <bits/stdc++.h>

using namespace std;

class Node{
    public :
        int data;
        Node * link;

    Node(int d = 0, Node * next = NULL){
        data = d;
        link = next;
    }
};
Node * createNode(int data, Node * next = NULL){
    Node * temp = new Node(data, next);
    return temp;
}
void addNodeAtLast(Node**head, int value){

    if(*head == NULL){
        *head = createNode(value);
        return;
    }
    else{
        Node * temp = *head;
        while(temp->link != NULL){
            temp = temp->link;
        }
        temp->link = createNode(value);
    }
}
void addNodeFirst(Node **head, int value)
{
    if(*head == NULL){
        *head = createNode(value);
    }
    else{
        Node * temp = createNode(value);
        temp->link = *head;
        *head = temp;
    }
}
void printReverse(Node *head){
    if(head == NULL)
        return;
    printReverse(head->link);
    cout<<head->data<<endl;
}
void printList(Node* temp){
    while(temp != NULL){
        cout<<temp->data<<endl;
        temp = temp->link;
    }
}
void addNodePosition(Node ** head, int value, int position){

    int count_ = 1;
    Node * prev_node = *head;
    while(count_ != position-1){
        prev_node = prev_node->link;
        count_ ++;
    }
    Node * newNode = createNode(value,  prev_node->link);
    prev_node->link = newNode;

}

void deleteFirstNode(Node ** head){
    Node *temp = *head;
    temp = temp->link;
    *head = temp;
}

void deleteLastAndMiddleNode(Node **head, int position){
    Node * temp = *head;
    Node *temp1 ;
    int count_ = 1;
    while(count_ < position - 1){
        temp = temp->link;
        count_++;
    }
    temp1 = temp->link;
    temp->link = temp1->link;
    temp1->link = NULL;
}
void reverseLinkedList(Node ** head){

    Node *temp = *head;
    Node *next = NULL, *prev = NULL;
    while(temp != NULL){
        next = temp->link;
        temp->link = prev;
        prev = temp;
        temp = next;
    }
    *head = prev;
}

//bool detectLoop(Node**head){
//    Node *h = *head;
//    unordered_set<Node *>s;
//    while(h!=NULL){
//        if(s.find(h) != s.end())
//            return true;
//        s.insert(h);
//        h = h->link;
//    }
//    return false;
//}

void raotateLinkedList(Node ** head, int k){

    Node *temp = *head;
    Node * next = *head;
    int count_ = 0, a, b;
    a = temp->data;
    while(count_ < k){

    }
}


void merge2LinkedList(Node ** head, Node ** head1){
    Node *temp = *head;
    while(temp->link != NULL){
        temp = temp->link;
    }
    temp->link = *head1;
}

int getNThElement(Node ** head, int elemnet){
    int value;
    int count_ = 1;
    Node * temp = *head;
    while(count_ != elemnet){
        temp = temp->link;
        count_++;
    }
    return temp->data;
}
int lengthOfLinkedList(Node * head){
    Node * temp = head;
    int count_ = 0;
    while(temp != NULL){
        temp = temp->link;
        count_++;
    }
    return count_;
}
int findInLinkedList(Node ** head, int value, bool from_reverse = false){
    Node * temp = *head;
    int count_ = 0;
    while(temp != NULL){
        if(temp->data == value ){
            return count_;
        }
        count_ ++;
        temp = temp->link;
    }
    if (from_reverse){
        int a = lengthOfLinkedList(temp);
        cout<< lengthOfLinkedList(temp)<<endl;
        return a - count_;

    }
    return -1;
}
int checkPalindrome(Node *temp){
    int n = lengthOfLinkedList(temp);
    Node * temp1 = temp;
    int arr[n];
    int count_= 0;
    while(temp != NULL){
        arr[count_] = temp->data;
        temp = temp -> link;
        count_ ++;
    }
    n = n - 1;
    while(temp1 != NULL){
        int a = arr[n];
//        cout<< "a is printing"<< a << endl;
        if(temp1->data != a){
            return 0;
        }
        temp1 = temp1->link;
        n--;
    }
    return 1;
}
void removeDuplicates(Node ** head){

    Node * temp = *head;
    Node * temp1, *nextNode ;
    while(temp != NULL && temp->link != NULL){
        temp1 = temp;
        while(temp1->link != NULL){
            if(temp->data == temp1->link->data){
                nextNode = temp1->link;
                temp1->link =  temp1->link->link;
                delete(nextNode);
            }
            else{
                temp1 = temp1->link;
            }
        }
        temp = temp->link;
    }
}

void findTriplates(Node ** head, int expected_value){

    Node * temp = *head;
    Node * next, *next_next;
    int count_ = 0;
    int sum = 0;
    while(temp != NULL){
        next = temp->link;
        next_next = next->link;
        if(temp->data + next->data + next_next->data == expected_value){
            cout<< temp->data << " " << next->data << " "  << next_next->data<<endl;
            break;
        }

        temp  = temp->link;
    }

}

void swapNodeWithoutSwapData(Node ** head, int firstIndex, int lastIndex){

    Node * start, *node1, *node2, *temp;
    start = *head;
    int count_ = 1;
    while(count_ != firstIndex - 1){
        start = start->link;
        count_++;
    }
    node1 = start;
    start = *head;
    count_ = 1;
    while(count_ != lastIndex - 1){
        start = start -> link;
        count_++;
    }
    node2 = start;
    temp = node2->link->link;
    node2->link->link = node1->link->link;
    node1->link->link = temp;
    temp = node1->link;
    node1->link = node2->link;
    node2->link = temp;
}

void segregatEvenNumber(Node ** head){
    Node *temp = *head;
    Node *hold = *head;
    int data;
    while(temp!=NULL){
        if(temp->data % 2 == 0 && hold->data % 2 != 0){
            data = temp->data;
            temp->data = hold->data;
            hold->data = data;
            hold = hold->link;
        }
        temp = temp->link;
    }
}

void pairSwap(Node ** head){

    Node *temp = *head;
//    Node *temp1, *temp2;
    while(temp != NULL && temp->link != NULL ){
        swap(temp->data, temp->link->data);
        temp = temp->link->link;
    }

}

void pairSwapLink(Node ** head){

    Node * prv = *head;
    Node *curr = prv->link;
    Node * next, *temp;
    *head = curr;
    while(next != NULL || next->link != NULL){
        if(*head == prv){
            next = curr->link;
            curr->link = prv;
            prv->link = next;
            prv = curr;
            curr = next;
            next = next->link;



        }
        else{
            next = curr->link;
            prv->link = next;
            temp = next->link;
            next->link = curr;
            curr->link = temp;
            prv = next;
            curr = curr->link;
            next = temp;

        }

    }
}

int main()
{
    Node * head = NULL;
    addNodeAtLast(&head, 1);
    addNodeAtLast(&head, 2);
    addNodeAtLast(&head, 3);
    addNodeAtLast(&head, 4);
    addNodeAtLast(&head, 5);
    addNodeAtLast(&head, 6);
//    reverseLinkedList(&head);
//    raotateLinkedList(&head, 4);
    pairSwapLink(&head);
    printList(head);
//    findTriplates(&head, 6);
//    segregatEvenNumber(&head);

//    Node *head1 = NULL;
//    addNodeAtLast(&head1, 7);
//    addNodeAtLast(&head1, 9);
//    addNodeAtLast(&head1, 10);
//    addNodeAtLast(&head1, 11);
//    addNodeAtLast(&head1, 12);
//    merge2LinkedList(&head, &head1);
//    printList(head);

//    swapNodeWithoutSwapData(&head,1,6);
//    printList(head);
//    removeDuplicates(&head);
//    cout<< "printing delete element\n";
//    printList(head);

//    addNodeFirst(&head,0);
//    cout<< "node added at first position\n";
//    printList(head);
//    deleteFirstNode(&head);
//    cout<<"added node in between\n";
//    addNodePosition(&head,4, 2);
//    printList(head);
//    cout<<"hello world\n";
//    cout<<getNThElement(&head, 3)<<endl;
//    cout<< "next element\n";
//    deleteLastAndMiddleNode(&head, 2);
//    printList(head);
//    cout<< "Length of the linked list is : " << lengthOfLinkedList(head);
//    cout<<"\nprinting value\n";
//    printList(head);
//    cout<< "position of digit is : "<<findInLinkedList(&head, 3,true)<<endl;
//    printList(head);
//    cout<< "\ncheck palindrome "<<checkPalindrome(head);
    return 0;
}


