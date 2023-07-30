<template>
    <main>
        <Navbar />

        <!--table-->>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="text-center">View Users</h1>

                    <a href="/add_user" class="btn btn-primary">Add Users</a>
                    <table class="table talbe=striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Account</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="user in users" :key="user.id">
                                <th scope="row">{{ user.id }}</th>
                                <td>{{ user.name }}</td>
                                <td>{{ user.email }}</td>
                                <td>{{ user.account }}</td>
                                <td>
                                    <a calss="btn btn-primary" :href="`/edit/${user.id}/${user.email}/${user.account}`" name=user.name>Edit</a>
                                    <button class="btn btn-danger mx-2" @click="$event => deleteUsers(user.id)">Delete</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </main>
</template>


<script>

import Navbar from '../components/Navbar.vue';

export default {
    name: 'ViewUsers',
    components : {
        Navbar
    },
    data(){
        return{
            users: []
        }
    },
    methods: {
        getUsers(){
            fetch('http://localhost:9000/users')
            .then(res => res.json())
            .then(data => {
                this.users = data
                console.log(data)
            })
        },
        deleteUsers(id){
            fetch(`http://localhost:9000/user/${id}`, {
                method: 'DELETE'
            })
            .then(data => {
                console.log(data)
                this.getUsers()
            })
        }
    },
    beforeMount(){
        this.getUsers()
    }
}

</script>