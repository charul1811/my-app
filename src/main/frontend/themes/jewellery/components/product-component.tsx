import React, { useEffect, useState } from 'react';
import {
    Container,
    Typography,
    Button,
    makeStyles,
} from '@material-ui/core';
import {Link} from "react-router-dom";
import {CartItemService, ProductService} from "Frontend/generated/endpoints";
import {Notification} from "@vaadin/react-components/Notification";


// Define product type
interface Product {
    id: number;
    name: string;
    price: number;
    imageUrl: string;
}
interface CartItem {
    product: Product;
    quantity: number;
    id: number;

}

// Define cart item type
interface ShoppingCart {

    cartItems:CartItem[];

}


// Styles for the component
const useStyles = makeStyles((theme) => ({
    productContainer: {
        padding: theme.spacing(4),
    },
    imageGrid: {
        marginTop: theme.spacing(2),
        marginBottom: theme.spacing(2),
    },
    productImage: {
        width: '100%',
        height: 'auto',
        borderRadius: theme.shape.borderRadius,
    },
    addToCartButton: {
        marginTop: theme.spacing(2),
    },
}));

const ProductComponent: React.FC = () => {
    const classes = useStyles();
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);
    const [products, setProducts] = useState<Product[]>([]);
    const [message, setMessage] = useState<string | null>(null);
    const[product, setProduct] = useState<Product | null>(null);
    useEffect(() => {
        // Fetch product data from API
        const fetchProducts = async () => {
            try {
                const products = await ProductService.listAll();
                console.log("products fetched", products);
// @ts-ignore
                setProducts(prevState => {
    return [...prevState, ...products];});
                setLoading(false);

            } catch (err) {
                setError('Failed to fetch product data.');
                setLoading(false);
            }
        };

        fetchProducts();
    }, []);




    if (loading) {
        return <Typography>Loading...</Typography>;
    }

    if (error) {
        return <Typography color="error">{error}</Typography>;
    }

    if (!products) {
        return <Typography>No product found.</Typography>;
    }

    return (
        <Container className={classes.productContainer}>
            <div style={styles.container}>
                <h1>Bijoux a la mode</h1>
                <div style={styles.grid}>

                    {products.map((product) => (
                        <div key={product.id} style={styles.card}>
                            <img src={product.imageUrl}  alt={product.name} style={styles.image} />
                            <h2 style={styles.name}>{product.name}</h2>
                            <p style={styles.price}>${product.price.toFixed(2)}</p>
                            <Button
                                className="addToCart"
                                onClick={async () => {
                                    const response = await CartItemService.save( product);
                                    Notification.show("Product added to cart");
                                }}
                                variant="contained"
                                color="primary"
                                fullWidth
                                type="submit"
                            >
                                Add to cart
                            </Button>
                            <p><Link to="/cart">Go to Cart</Link></p>
                            {message && <p>{message}</p>}
                        </div>
                    ))}
                </div>
            </div>


        </Container>
    );
};
const styles = {
    container: {
        padding: '20px',
        textAlign: 'center' as 'center',
    },
    grid: {
        display: 'grid',
        gridTemplateColumns: 'repeat(auto-fill, minmax(200px, 1fr))',
        gap: '16px',
    },
    card: {
        border: '1px solid #ccc',
        borderRadius: '8px',
        padding: '16px',
        textAlign: 'center' as 'center',
    },
    image: {
        width: '100%',
        height: 'auto',
    },
    name: {
        fontSize: '18px',
        margin: '10px 0',
    },
    price: {
        fontSize: '16px',
        margin: '10px 0',
    },
    button: {
        backgroundColor: '#007BFF',
        color: '#fff',
        border: 'none',
        borderRadius: '4px',
        padding: '10px 15px',
        cursor: 'pointer',
    },
};

export default ProductComponent;
