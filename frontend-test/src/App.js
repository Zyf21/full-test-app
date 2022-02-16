import * as React from 'react';
import {useEffect, useState} from 'react';
import TreeView from '@mui/lab/TreeView';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import ChevronRightIcon from '@mui/icons-material/ChevronRight';
import TreeItem from '@mui/lab/TreeItem';
import './App.css';
import {Button} from "@mui/material";
import Sector from "./service/SectorService";
import {createTheme} from '@mui/material/styles';
import {ThemeProvider} from "@emotion/react";
import axios from "axios";


function App() {

    const initialRecord = {
        id: 0,
        agree: false,
        userName: "",
        sectorNames: [{name: ""}]
    };

    const [inputName, setInputName] = useState('')
    const [sector, setSector] = useState([])
    const [selected, setSelected] = React.useState([]);
    const [sectorNames, setSectorNames] = React.useState([]);
    const [agree, setAgree] = useState(false)
    const [record, setRecord] = useState(initialRecord);
    const [notification, setNotification] = useState("");
    const [posted, setPosted] = useState(false)
    const API_BASE_RECORD_URL = "http://localhost:8080/api/records";

    const handleSelect = (event, nodeIds) => {
        let sectorNames = [];
        const search = (tree, target) => {
            for (const stack = [tree]; stack.length;) {
                const curr = stack.pop();
                if (curr.id === target) {
                    sectorNames.push({name: curr.name});
                    return curr.name;
                }
                stack.push(...curr.children);
            }
        };
        nodeIds.map(Number).forEach(function (id) {
            sector.forEach(function (item) {
                search(item, id);
            });
        });
        setSelected(nodeIds);
        setSectorNames(sectorNames);
    };

    const saveData = (e) => {
        e.preventDefault();
        if (inputName.trim() === "") {
            alert("The field Name must not be empty")

        } else {
            const recordRequest = {
                id: record.id,
                agree: agree,
                userName: inputName,
                sectorNames: sectorNames
            }

            if (!posted) {
                axios.post(API_BASE_RECORD_URL, recordRequest)
                    .then(res => {
                        setRecord(res.data)
                        setPosted(true)
                        setNotification("Record saved")
                    });
            } else {
                axios.put(API_BASE_RECORD_URL, recordRequest)
                    .then(res => setNotification("Record updated"));
            }
        }
    }

    useEffect(() => {
        getSectors()
    }, [])

    const getSectors = () => {
        Sector.getSectors().then((response) => {
            setSector(response.data)
        });
    };

    const renderTree = (nodes) =>
        nodes.map((item) => (
            <TreeItem key={item.id} nodeId={item.id.toString()} label={item.name}>
                {Array.isArray(item.children) ? renderTree(item.children) : null}
            </TreeItem>
        ));

    const theme = createTheme({
        palette: {
            action: {
                disabledBackground: 'rgba(87,86,86,0.55)',
                disabled: '#2a2a2a',
            },
        },
    });

    return (
        <div className="App">
            <header className="App-header">
                <div className='text'>Please enter your name and pick the Sectors you are currently involved in</div>
                <div className='nameInput'>
                    <div className='sectorsName'>Name:</div>
                    <input
                        value={inputName}
                        onChange={(e) => setInputName(e.target.value)}
                        type='text'
                        placeholder="Name"
                        className='inputName'/>
                </div>
                <div className='sectors'>
                    <div className='sectorsName'>Sectors:</div>
                    <div className='sector'>
                        <TreeView
                            onNodeSelect={handleSelect}
                            aria-label="controlled"
                            multiSelect
                            selected={selected}
                            defaultCollapseIcon={<ExpandMoreIcon/>}
                            defaultExpandIcon={<ChevronRightIcon/>}
                            sx={{height: 300, flexGrow: 1, maxWidth: 700, overflowY: 'visible', overflowX: 'hidden'}}>
                            {renderTree(sector)}
                        </TreeView>
                    </div>
                </div>

                <div className='save'>
                    <ThemeProvider theme={theme}>
                        <Button
                            color="primary"
                            disabled={!inputName || !agree || selected.length === 0}
                            onClick={saveData}
                            variant="contained"
                            size="small">Save
                        </Button>
                    </ThemeProvider>

                    <div>{notification}</div>
                    <label>
                        <input type="checkbox" onChange={(e) => setAgree(e.target.checked)}/>
                        <span>Agree to terms</span>
                    </label>
                </div>
            </header>
        </div>
    );
}

export default App;
