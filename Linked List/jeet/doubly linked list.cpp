#include<iostream>
using namespace std;

class Node {
    public:
        int data;
        Node* next;
        Node* prv;
    Node(int da = 0, Node* r = NULL, Node*l = NULL){
        data = da;
        next = r;
        prv = l;
    }

};
Node * createNode(int data, Node * next = NULL, Node * prev = NULL){
    Node * temp = new Node(data, next, prev);
    return temp;
}

void addNodeAtLast(Node **head, int value){
    Node * temp = *head;
    Node *temp2;
    if(temp == NULL){
        temp = createNode(value);
        *head = temp;
        return;
    }
    else{
        while(temp->next != NULL){
            temp = temp->next;
        }
        temp2 = createNode(value);
        temp->next = temp2;
        temp2->prv = temp;
    }

}
void addNodePosition(Node **head, int value, int position){

    Node *temp = *head, *temp2;
    int count_ = 0;
    while(count_ < position-1){
        count_++;
        temp = temp->next;
    }
    temp2 = temp->next;
    temp->next = createNode(value,temp2, temp);

}


void printList(Node *temp){
    while(temp!= NULL){
        cout<<temp->data<< "  ";
        temp = temp->next;
    }
    cout<<endl;

}

void deleteAllOccurance(Node ** head, int value){

    Node * temp = *head;
    Node *temp1;
    while(temp != NULL){
        if(temp->data == value){
            if(temp == *head){
                *head = temp->next;
                temp = temp->next;
            }
            else{
                temp1 = temp->prv;
                temp1->next = temp->next;
                temp = temp1;
            }


        }
        else{
            temp = temp->next;
        }
    }
}

void addFirstNode(Node **head, int value){
    Node *temp = *head, *temp1;
    temp1 = createNode(value, *head, NULL);
    temp->prv = temp1;
    *head = temp1;
}

void deleteLastNode(Node **head){

    Node * temp = *head, *temp1;
    while(temp->next != NULL){
        temp = temp->next;
    }
    temp1 = temp->prv;
    temp1->next = NULL;
    delete(temp);
}
void deleteFirstNode(Node ** head){
    Node *temp = *head;
    *head = temp->next;
    delete(temp);

}
void deleteNthNode(Node ** head, int position){

    Node *temp = *head, *temp1;
    int count_ = 0;
    while(count_ <= position-1){
        count_++;
        temp = temp->next;
    }
    temp1 = temp->prv;
    temp1->next = temp->next;
    delete(temp);
}

void reverseLinkedList(Node **head){
    Node * temp = NULL, *curr;
    curr = *head;
    while(curr != NULL){
        temp = curr->prv;
        curr->prv = curr->next;
        curr->next = temp;
        curr = curr->prv;
    }
    if(temp != NULL){
        *head = temp->prv;
    }
}
void deleteAllduplicate(Node ** head){

    Node *prv = *head;
    Node * next, *temp;
    while(prv->next != NULL){
        next  = prv->next;
        while(next != NULL){
            if(prv->data == next->data){
                temp = next->prv;
                temp->next = next->next;
                next = temp;
            }
            else{
                next = next->next;
            }
        }
        prv = prv->next;
    }


}

int main(){
    Node *head = NULL;
    addNodeAtLast(&head, 3);
    addNodeAtLast(&head, 2);
    addNodeAtLast(&head, 3);
    addNodeAtLast(&head, 3);
    addNodeAtLast(&head, 3);
    addNodeAtLast(&head, 3);
    addNodePosition(&head, 4, 1);
    printList(head);
    deleteAllduplicate(&head);
    printList(head);
//    addFirstNode(&head, 0);
//    reverseLinkedList(&head);
//    printList(head);
//    printList(head);
//    deleteNthNode(&head, 2);
//    printList(head);
//    deleteFirstNode(&head);
//    printList(head);
//    deleteLastNode(&head);

    return 0;
}
