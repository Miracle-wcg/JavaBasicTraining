package main.java.KotlinDemo

import KotlinDemo.Customer

fun main(args: Array<String>) {
    val customer = Customer("aaa");
    println(customer.name);
    customer.name = "ccc";
    println(customer.name);

}